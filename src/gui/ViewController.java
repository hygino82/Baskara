package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewController {

    @FXML
    private Button btCalcula;

    @FXML
    private Button btLimpa;

    @FXML
    private TextField txtValorA;

    @FXML
    private TextField txtValorB;

    @FXML
    private TextField txtValorC;

    @FXML
    private TextArea txtResultado;

    @FXML
    public void btCalculaAction() {
        txtResultado.clear();
        try {
            Double a = Double.parseDouble(txtValorA.getText());
            if (a == 0) {
                throw new IllegalArgumentException("O Valor de A não pode ser nulo.");
            } else {
                Double b = Double.parseDouble(txtValorB.getText());
                Double c = Double.parseDouble(txtValorC.getText());
                Double delta = b * b - 4 * a * c;
                Double xv = -b / (2 * a);
                Double yv = -delta / (4 * a);

                txtResultado.appendText("Delta = " + delta + "\n");
                txtResultado.appendText("Xv = " + xv + "\n");
                txtResultado.appendText("Yv = " + yv + "\n");

                if (delta > 0) {
                    Double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    Double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    txtResultado.appendText("A equação possui duas raízes distintas.\n");
                    txtResultado.appendText("X1 = " + x1 + "\n");
                    txtResultado.appendText("X2 = " + x2 + "\n");
                } else if (delta == 0) {
                    txtResultado.appendText("A equação possui duas raízes iguais.\n");
                    txtResultado.appendText("X1 = X2 = " + xv + "\n");
                } else {
                    Double complexa = Math.sqrt(-delta) / (2 * a);
                    txtResultado.appendText("A equação possui duas raízes complexas.\n");
                    if (xv != 0) {
                        txtResultado.appendText("X1 = " + xv + " + " + complexa + "i\n");
                        txtResultado.appendText("X2 = " + xv + " - " + complexa + "i\n");
                    } else {
                        txtResultado.appendText("X1 =  + " + complexa + "i\n");
                        txtResultado.appendText("X2 =  - " + complexa + "i\n");
                    }
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    @FXML
    public void btLimpaAction() {
        txtValorA.clear();
        txtValorB.clear();
        txtValorC.clear();
        txtResultado.clear();
    }
}
