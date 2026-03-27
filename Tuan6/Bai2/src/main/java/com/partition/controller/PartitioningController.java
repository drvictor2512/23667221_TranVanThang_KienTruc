package com.partition.controller;

import com.partition.entity.*;
import com.partition.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

@RestController
public class PartitioningController {

    @Autowired
    private UserMaleRepository userMaleRepository;

    @Autowired
    private UserFemaleRepository userFemaleRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserActiveRepository userActiveRepository;

    @Autowired
    private UserInactiveRepository userInactiveRepository;

    @Autowired
    private UserSuspendedRepository userSuspendedRepository;

    // 1. Horizontal Partitioning
    @GetMapping("/horizontal")
    public Map<String, Object> getHorizontalPartitioning() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("title", "🔀 HORIZONTAL PARTITIONING (by Gender)");
        result.put("description", "Chia dữ liệu thành các bảng riêng biệt theo gender");
        
        long maleCount = userMaleRepository.count();
        long femaleCount = userFemaleRepository.count();
        
        result.put("male_count", maleCount);
        result.put("female_count", femaleCount);
        result.put("male_data", userMaleRepository.findAll());
        result.put("female_data", userFemaleRepository.findAll());
        result.put("benefit", "✅ Query riêng từng bảng → Performance tốt | ✅ Dễ quản lý dữ liệu lớn");
        
        return result;
    }

    // 2. Vertical Partitioning
    @GetMapping("/vertical")
    public Map<String, Object> getVerticalPartitioning() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("title", "📊 VERTICAL PARTITIONING (Profile + Detail)");
        result.put("description", "Chia cột dữ liệu: basic info vs sensitive data");
        
        List<Map<String, Object>> data = new ArrayList<>();
        List<UserProfile> profiles = userProfileRepository.findAll();
        
        for (UserProfile profile : profiles) {
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("profile", profile);
            UserDetail detail = userDetailRepository.findByUserId(profile.getId());
            item.put("detail", detail);
            data.add(item);
        }
        
        result.put("data_count", data.size());
        result.put("data", data);
        result.put("benefit", "✅ Profile table nhỏ, query nhanh | ✅ Detail table riêng, bảo mật tốt");
        
        return result;
    }

    // 3. Function-based Partitioning
    @GetMapping("/function")
    public Map<String, Object> getFunctionPartitioning() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("title", "⚙️ FUNCTION-BASED PARTITIONING (by Status Logic)");
        result.put("description", "Chia dữ liệu theo logic: Active/Inactive/Suspended");
        
        long activeCount = userActiveRepository.count();
        long inactiveCount = userInactiveRepository.count();
        long suspendedCount = userSuspendedRepository.count();
        
        result.put("active_count", activeCount);
        result.put("inactive_count", inactiveCount);
        result.put("suspended_count", suspendedCount);
        result.put("active_data", userActiveRepository.findAll());
        result.put("inactive_data", userInactiveRepository.findAll());
        result.put("suspended_data", userSuspendedRepository.findAll());
        result.put("benefit", "✅ Isolate suspended users | ✅ Query active users rất nhanh");
        
        return result;
    }

    // Homepage
    @GetMapping("/")
    public String homepage() {
        return """
<!DOCTYPE html>
<html>
<head>
    <title>Database Partitioning Demo - Spring Boot</title>
    <style>
        body { font-family: Arial; margin: 20px; background: #f5f5f5; }
        h1 { color: #333; }
        .container { max-width: 1000px; margin: 0 auto; }
        .endpoint { 
            background: white; 
            padding: 15px; 
            margin: 10px 0; 
            border-radius: 5px;
            border-left: 5px solid #28a745;
        }
        a { 
            display: inline-block;
            background: #28a745; 
            color: white; 
            padding: 8px 15px; 
            text-decoration: none;
            border-radius: 3px;
            margin: 5px;
        }
        a:hover { background: #218838; }
        code { background: #f0f0f0; padding: 2px 5px; font-weight: bold; }
    </style>
</head>
<body>
    <div class="container">
        <h1>📚 Database Partitioning Demo - Spring Boot Java</h1>
        <p>Chọn loại partitioning để xem demo:</p>
        
        <div class="endpoint">
            <h3>1️⃣ Horizontal Partitioning (Chia hàng)</h3>
            <p>Split users by gender → <code>users_male</code> & <code>users_female</code></p>
            <a href="/horizontal">👉 Xem Demo</a>
        </div>
        
        <div class="endpoint">
            <h3>2️⃣ Vertical Partitioning (Chia cột)</h3>
            <p>Split columns → <code>users_profile</code> & <code>users_detail</code></p>
            <a href="/vertical">👉 Xem Demo</a>
        </div>
        
        <div class="endpoint">
            <h3>3️⃣ Function-based Partitioning (Chia logic)</h3>
            <p>Split by status → <code>users_active</code>, <code>users_inactive</code>, <code>users_suspended</code></p>
            <a href="/function">👉 Xem Demo</a>
        </div>
        
        <hr>
        <h3>✨ Lợi ích:</h3>
        <ul>
            <li>✅ <strong>Tăng performance</strong> - Query trên bảng nhỏ hơn</li>
            <li>✅ <strong>Cải thiện scalability</strong> - Dễ mở rộng</li>
            <li>✅ <strong>Tốt cho quản lý</strong> - Dữ liệu tổ chức tốt</li>
            <li>✅ <strong>Bảo mật tốt</strong> - Tách dữ liệu nhạy cảm</li>
        </ul>
    </div>
</body>
</html>
""";
    }
}
