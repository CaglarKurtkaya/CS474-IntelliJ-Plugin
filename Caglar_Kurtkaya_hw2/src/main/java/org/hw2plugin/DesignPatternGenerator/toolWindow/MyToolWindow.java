package org.hw2plugin.DesignPatternGenerator.toolWindow;



import com.intellij.openapi.wm.ToolWindow;;
import org.hw2plugin.DesignPatternGenerator.DPG.DePaCoG;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyToolWindow {

    private JPanel myToolWindowContent;
    private JLabel label;
    private JButton abstractFactoryButton;
    private JButton builderButton;
    private JButton factoryButton;
    private JButton facadeButton;
    private JButton chainButton;
    private JButton mediatorButton;
    private JButton visitorButton;
    private JButton templateButton;
    private String path;

    private UserInputDialogWrapper myUserInputWrapper;
    private static final Logger logger = LoggerFactory.getLogger("MyToolWindow");
    DePaCoG dePaCoG = new DePaCoG();



    public MyToolWindow(ToolWindow toolWindow, String path){
        this.path = path;
        init();
    }



    public void init(){

        //Listens the action performed on abstractFactoryButton
        abstractFactoryButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("User clicked on  abstractFactoryButton, performing now!");
                myUserInputWrapper = new UserInputDialogWrapper(1);
                    if(myUserInputWrapper.showAndGet()){
                        // user pressed ok
                        logger.info("User clicked ok");
                        //generate the code
                        dePaCoG.generateAbstractFactoryPattern(myUserInputWrapper.getClassName(),myUserInputWrapper.getProductType(),myUserInputWrapper.getProductName(),myUserInputWrapper.getPackName(),path);

                    }
            }
        });

        //Listens the action performed on builderButton
        builderButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("User clicked on builderButton, performing now!");
                myUserInputWrapper = new UserInputDialogWrapper(1);
                if(myUserInputWrapper.showAndGet()){
                    // user pressed ok
                    logger.info("User clicked ok");
                    // generate the code
                    dePaCoG.generateBuilderPattern(myUserInputWrapper.getClassName(),myUserInputWrapper.getProductType(),myUserInputWrapper.getProductName(),myUserInputWrapper.getPackName(),path);

                }

            }

        });

        //Listens the action performed on factoryButton
        factoryButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("User clicked on factoryButton, performing now!");
                myUserInputWrapper = new UserInputDialogWrapper(1);
                if(myUserInputWrapper.showAndGet()){
                    // user pressed ok
                    logger.info("User clicked ok");
                    dePaCoG.generateFactoryPattern(myUserInputWrapper.getClassName(),myUserInputWrapper.getProductType(),myUserInputWrapper.getProductName(),myUserInputWrapper.getPackName(),path);

                }

            }

        });

        //Listens the action performed on facadeButton
        facadeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("User clicked on facadeButton, performing now!");
                myUserInputWrapper = new UserInputDialogWrapper(2);
                if(myUserInputWrapper.showAndGet()){
                    // user pressed ok
                    logger.info("User clicked ok");
                    dePaCoG.generateFacadePattern(myUserInputWrapper.getClassName(),myUserInputWrapper.getPackName(),path);

                }

            }

        });


        //Listens the action performed on chainButton
        chainButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("User clicked on chainButton, performing now!");
                myUserInputWrapper = new UserInputDialogWrapper(2);
                if(myUserInputWrapper.showAndGet()){
                    // user pressed ok
                    logger.info("User clicked ok");
                    //generates the code
                    dePaCoG.generateChainPattern(myUserInputWrapper.getClassName(),myUserInputWrapper.getPackName(),path);

                }

            }

        });

        //Listens the action performed on mediatorButton
        mediatorButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("User clicked on mediatorButton");
                myUserInputWrapper = new UserInputDialogWrapper(2);
                if(myUserInputWrapper.showAndGet()){
                    // user pressed ok
                    logger.info("User clicked ok");
                    //generates the code
                    dePaCoG.generateMediatorPattern(myUserInputWrapper.getClassName(),myUserInputWrapper.getPackName(),path);

                }
            }
        });

        //Listens the action performed on visitorButton
        visitorButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("User clicked on visitorButton");
                myUserInputWrapper = new UserInputDialogWrapper(2);
                if(myUserInputWrapper.showAndGet()){
                    // user pressed ok
                    logger.info("User clicked ok");
                    //generates the code
                    dePaCoG.generateVisitorPattern(myUserInputWrapper.getClassName(),myUserInputWrapper.getPackName(),path);

                }
            }

        });


        //Listens the action performed on templateButton
        templateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("User clicked on templateButton");
                myUserInputWrapper = new UserInputDialogWrapper(2);
                if(myUserInputWrapper.showAndGet()){
                    // user pressed ok
                    logger.info("User clicked ok");
                    //generates the code
                    try {
                        dePaCoG.generateTemplatePattern(myUserInputWrapper.getClassName(), myUserInputWrapper.getPackName(), path);
                    }
                    catch (IllegalArgumentException ie){
                        ie.printStackTrace();
                    }
                }
            }
        });

    }



    public JPanel getContent(){
        logger.info("myToolWindowContent has been returned");
        return myToolWindowContent;
    }

}
