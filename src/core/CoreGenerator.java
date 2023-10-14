package core;

import alert.Alert;
import app.layout.App;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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

    public boolean isURLValid(String URL) {
        String regex = "^(http|https|ftp)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}(:[0-9]+)?(/[a-zA-Z0-9_/-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(URL);

        return matcher.matches();
    }

    public void setStatus(String URL, JLabel jLabel) {
        if (isURLValid(URL)) {
            jLabel.setForeground(UIManager.getColor("JLabel.foreground"));
            jLabel.setText("Status: Valid URL");
        } else {
            jLabel.setForeground(Color.RED);
            jLabel.setText("Status: Not Valid URL");
        }
    }

    public void setDimension(int value, JLabel jLabel) {
        switch (value) {
            case 0:
                jLabel.setText("Dimension: 256 x 256");
                break;
            case 2:
                jLabel.setText("Dimension: 1024 x 1024");
                break;
            default:
                jLabel.setText("Dimension: 512 x 512");
                break;
        }
    }

    public String getChosenColor() {
        Color selectedColor = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
        int red = selectedColor.getRed();
        int green = selectedColor.getGreen();
        int blue = selectedColor.getBlue();
        String rgbString = String.format("RGB [ %d, %d, %d ]", red, green, blue);

        int rgbValue = selectedColor.getRGB();
        String hexString = String.format("HEX [ #%06X ]", (0xFFFFFF & rgbValue));

        return rgbString + " - " + hexString;
    }

    public void generateQRCode(String URL, String filePath, int width, int height, String format, Color backgroundColor, Color qrCodeColor) {
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        try {
            BitMatrix bitMatrix = new QRCodeWriter().encode(URL, BarcodeFormat.QR_CODE, width, height, hints);

            // Create a BufferedImage to apply colors
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Set background color
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, backgroundColor.getRGB());
                }
            }

            // Set QR code color
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (bitMatrix.get(x, y)) {
                        image.setRGB(x, y, qrCodeColor.getRGB());
                    }
                }
            }

            // Write the image to the specified file
            ImageIO.write(image, format, new File(filePath));
        } catch (WriterException | IOException e) {
            new Alert(e.getMessage());
        }
    }

    public void reset(JFrame jFrame) {
        jFrame.dispose();
        new App(1);
    }
}
