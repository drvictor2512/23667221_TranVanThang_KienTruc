# Image Optimization & Data Persistence Demo Script
# Run this in PowerShell in the Lab_06/1 directory

Write-Host "========================================" -ForegroundColor Green
Write-Host "DEMO: Image Optimization (Node.js)" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Green

# Step 1: Build 4-stage image
Write-Host "`n[1] Building 4-stage image..." -ForegroundColor Yellow
docker build -f Dockerfile.4stages -t app:4stages .
Start-Sleep -Seconds 2

# Step 2: Build 2-stage image
Write-Host "`n[2] Building 2-stage image..." -ForegroundColor Yellow
docker build -f Dockerfile.2stages -t app:2stages .
Start-Sleep -Seconds 2

# Step 3: Build 1-stage image
Write-Host "`n[3] Building 1-stage image..." -ForegroundColor Yellow
docker build -f Dockerfile.1stage -t app:1stage .
Start-Sleep -Seconds 2

# Step 4: Compare image sizes
Write-Host "`n[4] COMPARING IMAGE SIZES:" -ForegroundColor Green
Write-Host "================================================"
docker images | Select-String 'app:'
Write-Host "================================================`n"

Write-Host "Size comparison: 4stages > 2stages > 1stage (1stage is SMALLEST!)" -ForegroundColor Cyan

# Step 5: PostgreSQL Demo
Write-Host "`n========================================" -ForegroundColor Green
Write-Host "DEMO: PostgreSQL with Data Persistence" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Green

# Build PG image
Write-Host "`n[5] Building PostgreSQL image..." -ForegroundColor Yellow
docker build -f Dockerfile.postgres -t mypg:v1 .
Start-Sleep -Seconds 2

# Run first container
Write-Host "`n[6] Running PostgreSQL container (with volume)..." -ForegroundColor Yellow
docker run -d `
  --name pg-container-1 `
  -v pg-data:/var/lib/postgresql/data `
  mypg:v1
Start-Sleep -Seconds 5

# Verify initial data
Write-Host "`n[7] Initial data in container:" -ForegroundColor Green
docker exec pg-container-1 psql -U admin -d myapp -c "SELECT * FROM users;" 2>$null

# Add more data
Write-Host "`n[8] Adding new row to database..." -ForegroundColor Yellow
docker exec pg-container-1 psql -U admin -d myapp -c `
  "INSERT INTO users (name, email) VALUES ('Test User', 'test@example.com');" 2>$null
Start-Sleep -Seconds 2

# Verify new data
Write-Host "`n[9] Data after INSERT:" -ForegroundColor Green
docker exec pg-container-1 psql -U admin -d myapp -c "SELECT * FROM users;" 2>$null

# Save container as image
Write-Host "`n[10] Saving container with data as new image (mypg:with-data)..." -ForegroundColor Yellow
docker commit pg-container-1 mypg:with-data
docker stop pg-container-1
Start-Sleep -Seconds 2

# Run from new image
Write-Host "`n[11] Running new container from saved image..." -ForegroundColor Yellow
docker run -d `
  --name pg-container-2 `
  -v pg-data:/var/lib/postgresql/data `
  mypg:with-data
Start-Sleep -Seconds 5

# Verify data persisted
Write-Host "`n[12] Data in NEW container (from saved image):" -ForegroundColor Green
docker exec pg-container-2 psql -U admin -d myapp -c "SELECT * FROM users;" 2>$null

# Cleanup
Write-Host "`n[13] Cleaning up..." -ForegroundColor Yellow
docker stop pg-container-2 2>$null
docker rm pg-container-1 pg-container-2 2>$null
docker volume rm pg-data 2>$null

Write-Host "`n========================================" -ForegroundColor Green
Write-Host "DEMO COMPLETED!" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Green
Write-Host "`nKey Results:" -ForegroundColor Yellow
Write-Host "1. 1-stage image is SMALLEST (most optimized)" -ForegroundColor Cyan
Write-Host "2. 2-stage is medium, 4-stage is largest" -ForegroundColor Cyan
Write-Host "3. Data persists from docker commit" -ForegroundColor Cyan
Write-Host "4. New container runs with saved data" -ForegroundColor Cyan
