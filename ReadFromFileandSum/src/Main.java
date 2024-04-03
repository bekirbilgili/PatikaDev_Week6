import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception { // try catch bloğu çok uzadığı için metoda throws eklendi.

        int[] inputArray = {5, 10, 20, 12, 33}; // Girişteki veriler bir arrayde tanımlandı.

        // Değerlerin içine yazdırılacağı txt dosyası oluşturuldu
        File file = new File("ReadFromFileandSum/src/inputfile.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Dosya oluşturuldu.");
        } else {
            System.out.println("Dosya oluşturulamadı. Zaten mevcut.");
        }

        FileWriter fileWriter = new FileWriter(file); // Dosyaya yazma için file sınıfından nesneler oluşturuldu.
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        for (int i : inputArray) { // arraydeki değerler txt dosyasına yazılır.
            buffWriter.write(String.valueOf(i));
            buffWriter.newLine();
        }
        buffWriter.close();
        fileWriter.close();

        FileReader fileReader = new FileReader(file);//Dosyayı okumak için nesneler ürelildi.
        BufferedReader bufferReader = new BufferedReader(fileReader);

        String textLine;
        int sum = 0;

        System.out.println("Dosyadaki Değerler: ");
        while ((textLine = bufferReader.readLine()) != null) { // dosyaddaki değerler tek tek alınır ve toplanır.
            System.out.println(textLine);
            sum += Integer.parseInt(textLine);
        }
        fileReader.close();
        bufferReader.close();

        System.out.println("Dosyadaki değerlerin toplamı: " + sum);
    }
}

