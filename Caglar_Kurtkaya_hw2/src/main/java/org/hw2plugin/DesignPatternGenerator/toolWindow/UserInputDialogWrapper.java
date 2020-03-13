package org.hw2plugin.DesignPatternGenerator.toolWindow;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/*
This class is used to prompt a dialog window to get user input
 */
public class UserInputDialogWrapper extends DialogWrapper {
    private static final Logger logger = LoggerFactory.getLogger("UserInputDialogWrapper");
    //Dynamic forms
    //Some design patterns require different user input window
    private Form1 f1 = new Form1();
    private Form2 f2 = new Form2();
    private JPanel panel1, panel2;


    private int choosePanel;


    //Getters
    public String getClassName() {
        return className;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductName() {
        return productName;
    }

    public String getPackName() {
        return packName;
    }
    public int getChoosePanel(){
        return this.choosePanel;
    }
    public Form1 getF1(){
        return f1;
    }
    public Form2 getF2(){
        return f2;
    }
    public JPanel getPanel1(){
        return panel1;
    }
    public JPanel getPanel2(){
        return panel2;
    }
    //Setter
    public void setChoosePanel(int i){
        this.choosePanel = i;
    }

    //String variables to get user input
    private String  className, productType,productName, packName;


    public UserInputDialogWrapper(int choose) {
        super(true); // use current window as parent

        this.choosePanel = choose;

        setTitle("USER INPUT");

        logger.info("UserInputDialogWrapper has been initialized");
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {

        createUIComponents();
        logger.debug("Panel {} returned ", this.choosePanel);
        return this.choosePanel == 1 ? panel1 : panel2;
    }

    @Override
    protected void doOKAction() {
        //Convert the text field input into string
        if(this.choosePanel == 1){
            className = f1.getClassNameText().getText();
            productType = f1.getProductTypeText().getText();
            productName = f1.getProductNameText().getText();
            packName = f1.getPackNameText().getText();

            logger.debug("className = {}", className);
            logger.debug("productType = {}", productType);
            logger.debug("productName = {}", productName);
            logger.debug("packName = {}", packName);

        }

        if(this.choosePanel == 2){
            className = f2.getClassNameText().getText();
            packName = f2.getPackNameText().getText();

            logger.debug("className = {}", className);
            logger.debug("packName = {}", packName);
        }

        //Close the pop up window after user press the ok button
        close(0);
    }

    private void createUIComponents() {
        panel1 = f1.getPanel();
        panel2 = f2.getPanel();
    }
}