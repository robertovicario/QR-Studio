package core;

import alert.Alert;
import alert.Info;
import app.layout.App;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
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

/**
 * @author Roberto Vicario
 * @version 1.0
 */
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

    public Dimension getDimension(int value) {
        return switch (value) {
            case 0 -> new Dimension(256, 256);
            case 2 -> new Dimension(1024, 1024);
            default -> new Dimension(512, 512);
        };
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

    public String chooseColor() {
        Color selectedColor = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
        int red = selectedColor.getRed();
        int green = selectedColor.getGreen();
        int blue = selectedColor.getBlue();

        return String.format("RGB [ %d, %d, %d ]", red, green, blue);
    }

    public Color getChosenColor(String text) {
        String regex = "RGB \\[ (\\d+), (\\d+), (\\d+) ]";
        Pattern pattern = java.util.regex.Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int r = 0, g = 0, b = 0;
        if (matcher.find()) {
            r = Integer.parseInt(matcher.group(1));
            g = Integer.parseInt(matcher.group(2));
            b = Integer.parseInt(matcher.group(3));
        }

        return new Color(r, g, b);
    }

    public BufferedImage generateQRCode(String URL, int width, int height, Color background, Color color) {
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        BitMatrix bitMatrix;
        try {
            bitMatrix = new QRCodeWriter().encode(URL, BarcodeFormat.QR_CODE, width, height, hints);
        } catch (WriterException e) {
            new Alert(e.getMessage());
            return null;
        }

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, background.getRGB());
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (bitMatrix.get(x, y)) {
                    image.setRGB(x, y, color.getRGB());
                }
            }
        }

        return image;
    }

    public void downloadQRCode(String URL, int width, int height, String format, Color background, Color color) {
        BufferedImage image = generateQRCode(URL, width, height, background, color);

        if (image == null) {
            new Alert("QR code generation failed.");

            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        int saveResult = fileChooser.showSaveDialog(null);

        if (saveResult == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            if (!filePath.endsWith("." + format)) {
                filePath += "." + format;
            }

            try {
                ImageIO.write(image, format, new File(filePath));
            } catch (IOException e) {
                new Alert(e.getMessage());
            }

            new Info("QR code successfully generated.");
        }
    }

    public void resetComponents(JFrame jFrame) {
        jFrame.dispose();
        new App(1);
    }
}
