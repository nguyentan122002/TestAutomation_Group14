package Common.Common;

import java.io.File;

public class Utilities {
    public static String getProjectPath() {
        String projectPath = new File("D:\\tester\\final").getAbsolutePath();
        return projectPath;
    }
}