import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class HB extends Application{
    public static void main(String[] args){
        launch(args);
    }

    Number hb = new Number();

    public void start(Stage myStage){
        myStage.setTitle("Hit and Blow");
        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.TOP_LEFT);

        Scene myScene = new Scene(rootNode,500,500);
        myStage.setScene(myScene);

        TextField number = new TextField();
        number.setPrefWidth(46);

        Label message = new Label();
        Label intro = new Label("\tゲームのルール説明：\n\t\t1.プログラムによって、重複のない4桁の数字が決められています。");
        Label intro2 = new Label("\t\t2.テキストフィールドに4桁の数字を入力して推測してください。");
        Label intro3 = new Label("\t\t3.入力後、以下の情報が表示されます：\n\t\t\t・Hit：位置と数字が両方合っている数の個数\n\t\t\t・Blow：数字は合っているが位置が違う数の個数");
        Label intro4 = new Label("\t\t4.これらの情報を使って推理を重ね、正解の4桁の数字を当ててください。");
        Label rule = new Label("\t入力のルール：\n\t\t・以下の入力はエラーとなり、再入力が必要です。");
        Label rule2 = new Label("\t\t\t*4桁以外の数字\n\t\t\t*数字以外の文字\n\t\t\t*重複した数字を含む入力\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        Label tab = new Label("\t\t");
        hb.getAns();

        Button ok = new Button("                    OK                    ");
        Button restart = new Button("                   Restart                    ");

        ok.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                message.setText(hb.Memory(number.getText()));
                number.setText("");
                hb.Reset();
            }
        });

        restart.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                hb.Restart();
                message.setText("");
            }
        });

        rootNode.getChildren().addAll(intro,intro2,intro3,intro4,rule,rule2,tab,number,ok,restart,message);
        rootNode.setPrefWrapLength(300);
        myStage.show();
    }
}