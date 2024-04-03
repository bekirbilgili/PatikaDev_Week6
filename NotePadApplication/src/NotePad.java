import java.util.Scanner;
import java.io.*;

public class NotePad {
    public static void main(String[] args) {
        // Metni saklamak için bir dosya oluşturulur
        File dosya = new File("notepad.txt");

        try {
            if (!dosya.exists()) {
                dosya.createNewFile();
            }

            // Dosyadan metni okumak için BufferedReader kullanılır
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dosya));

            // Eğer dosyada metin varsa, metni ekrana yazdırır
            String initialText;
            while ((initialText = bufferedReader.readLine()) != null) {
                System.out.println(initialText);
            }

            // Kullanıcıdan giriş alır
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nLütfen metni girin (Çıkmak için 'q' girin):");

            // Kullanıcı 'q' girene kadar girişi dosyaya yazar
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(dosya));
            String userText;
            while ((userText = buffReader.readLine()) != null) {
                buffWriter.write(userText);
                buffWriter.newLine();
            }

            buffWriter.close();
            bufferedReader.close();
            buffReader.close();

        } catch (IOException e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }
}
