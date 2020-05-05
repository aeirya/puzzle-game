package test;

import java.io.File;

public class TestMain {
    public static void main(String[] args) {
        new TestMain();
    }

    public TestMain() {
        String path = "src/resources/assets/";
        File file = new File(path+"1.jpg");
        for (File f : file.getParentFile().listFiles()) {
            if (f.exists()) System.out.println(f.getPath());
        }
    }
}