import java.io.*;

class FunWithStreams {

    final String FILE_NAME = "stuff.txt";

    private void writeToAFile() {
        File file = new File(FILE_NAME);
        try (Writer fileWriter = new FileWriter(file)) {
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            for( ;;) {
                String line = reader.readLine();
                if ((line == null) || (line.equals(""))) {
                    break;    
                }
                fileWriter.write(line + "\n");
            }

            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void readFromAFile() {
      File file = new File(FILE_NAME);
      try( BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line = null;
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
      } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }

    public static void main(String[] args) {
        FunWithStreams fun = new FunWithStreams();
        fun.writeToAFile();

        fun.readFromAFile();
    }
}
