import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("D://Games//src"),
                new File("D://Games//res"),
                new File("D://Games//saveGames"),
                new File("D://Games//temp"),
                new File("D://Games//src//main"),
                new File("D://Games//src//test"),
                new File("D://Games//src//drawables"),
                new File("D://Games//src//vectors"),
                new File("D://Games//src//icons")
        );

        List<File> fileList = Arrays.asList(
                new File("D://Games//src//main//Main.java"),
                new File("D://Games//src//main//Utils.java"),
                new File("D://Games//temp//temp.txt")
        );

        folderList.forEach(folder -> {
            if (folder.mkdir()) sb.append("Фаил ").append(folder).append(" создан\n");
            else sb.append("Фаил ").append(folder).append(" не создан\n");
        });

        fileList.forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Фаил ").append(file).append(" создан\n");
                else sb.append("Фаил ").append(file).append(" не создан\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

        try (FileWriter log = new FileWriter("D://Games//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException e) {
            sb.append(e.getMessage()).append('\n');
        }

        try (BufferedReader br = new BufferedReader(new FileReader("D://Games//temp//temp.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line + '\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

