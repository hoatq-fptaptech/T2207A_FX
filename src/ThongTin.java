import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ThongTin {

    public TextField txtFullName;
    public TextField txtEmail;
    public Text txtInfo;

    public void submit(ActionEvent actionEvent) {
        String fn = txtFullName.getText();
        String em = txtEmail.getText();
        String txt = txtInfo.getText();
        txt += "\n=================";
        txt += "\nFullname: "+fn+"\n"+"Email: "+em;
        txtInfo.setText(txt);
    }
}
