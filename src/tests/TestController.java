package tests;

import org.cbrnrd.alertfx.*;

/**
 * Created by Carter on 5/30/17.
 */
public class TestController {

    public void startTests(){
        MsgBox box = new MsgBox("Test 1");
        box.show();

        Prompt p = new Prompt("Test 2");
        p.show();

        Exception exception = new Exception("Test 3");
        ErrorBox errorBox = new ErrorBox(exception);
        errorBox.show();

        ConfirmExit confirmExit = new ConfirmExit();
        confirmExit.show();

        Warn warn = new Warn("Test 5");
        warn.show();

        ChoiceBox choiceBox = new ChoiceBox("Test 6");
        choiceBox.show();

        QuestionBox questionBox = new QuestionBox("Test 7");
        questionBox.show();

    }
}
