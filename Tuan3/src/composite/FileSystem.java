package composite;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showInfo();
}

class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showInfo() {
        System.out.println("File: " + name + " (Size: " + size + " KB)");
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showInfo() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showInfo();
        }
    }
}

public class FileSystem {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 120);
        File file2 = new File("file2.jpg", 350);

        Directory subDirectory = new Directory("subDirectory");
        subDirectory.addComponent(file1);
        subDirectory.addComponent(file2);

        Directory mainDirectory = new Directory("mainDirectory");
        mainDirectory.addComponent(subDirectory); 

        mainDirectory.showInfo();
    }
}
