package core;

import alert.Alert;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoreGenerator {
    public void checkURL(String URL) {
        try {
            URI uri = new URI(URL);
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException ex) {
            new Alert(ex.getMessage());
        }
    }

    public boolean URLIsValid(String URL) {
        String regex = "^(http|https|ftp)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}(:[0-9]+)?(/[a-zA-Z0-9_/-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(URL);

        return matcher.matches();
    }

    public void setStatus(String URL, JLabel jLabel) {
        if (URLIsValid(URL)) {
            jLabel.setForeground(UIManager.getColor("JLabel.foreground"));
            jLabel.setText("Status: Valid URL");
        } else {
            jLabel.setForeground(Color.RED);
            jLabel.setText("Status: Not Valid URL");
        }
    }

    public void generateQR(String URL, String filePath, int width, int height, String format) {
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(URL, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToPath(bitMatrix, format, new File(filePath).toPath());
        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
