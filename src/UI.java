import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @author zx328
 */
public class UI extends JFrame implements ActionListener {


    JMenuBar menuBar;
    JToolBar toolBar;
    JMenu menuFile,menuEdit,menuFind,menuAbout,menuColor;
    JButton newButton,undoButton,redoButton,boldButton,italicsButton,bottomlineButton;
    JMenuItem openFile,saveFile,saveFileAs,cut,paste,copy,blue,red,pink;

    JLabel stateBar;

    StyleContext sc=new StyleContext();
    DefaultStyledDocument doc=new DefaultStyledDocument(sc);
    JTextPane textPane=new JTextPane(doc);



    DefineImageButton defineImageButton = new DefineImageButton();





    public UI(){
        super("新增文字檔案");
        this.setIconImage(new ImageIcon("./assets/image/mainicon/nick.jpg").getImage());
        setUpUIComponent();
        setUpEventListener();
        setVisible(true);
    }


    private void setUpEventListener() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //word-count-listener

    }

    private void setUpUIComponent() {
        setSize(640, 480);
        toolBar=new JToolBar();
        menuBar=new JMenuBar();
        //menuFile
        menuFile=new JMenu("檔案");

         openFile = new JMenuItem("開啟舊檔");
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

         saveFile = new JMenuItem("儲存檔案");
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

         saveFileAs = new JMenuItem("另存新檔");
        saveFileAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, InputEvent.CTRL_DOWN_MASK));

        menuFile.add(openFile);
        menuFile.addSeparator();
        menuFile.add(saveFile);
        menuFile.add(saveFileAs);


        //menuEdit
        menuEdit=new JMenu("編輯");
        cut=new JMenuItem("剪下");
        copy=new JMenuItem("複製");
        paste=new JMenuItem("貼上");
        menuEdit.add(cut);
        menuEdit.add(copy);
        menuEdit.add(paste);


        //menuFind
        menuFind=new JMenu("尋找");


        //menuAbout
        menuAbout=new JMenu("關於");

        //menuColor
        menuColor=new JMenu("字體顏色");
        blue=new JMenuItem("藍色");
        red=new JMenuItem("紅色");
        pink=new JMenuItem("粉紅色");
        blue.addActionListener(new FontEdit(textPane));
        red.addActionListener(new FontEdit(textPane));
        pink.addActionListener(new FontEdit(textPane));
        menuColor.add(blue);
        menuColor.add(red);
        menuColor.add(pink);




        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFind);
        menuBar.add(menuColor);
        menuBar.add(menuAbout);

        //建立新檔
        newButton=new JButton(defineImageButton.newIcon);

        //上一步
        undoButton=new JButton(defineImageButton.undoIcon);

        //粗體
        boldButton = new JButton(defineImageButton.boldIcon);
        boldButton.setToolTipText("粗體");
        boldButton.setText("bold");
        boldButton.setFont(new Font("bold",0,0));
        boldButton.addActionListener(new Bold(textPane));

        //斜體
        italicsButton = new JButton(defineImageButton.italicsIcon);
        italicsButton.setToolTipText("斜體");
        italicsButton.setText("italics");
        italicsButton.setFont(new Font("italics",0,0));
        italicsButton.addActionListener(new Italics(textPane));

        //textUnderLine
        bottomlineButton = new JButton(defineImageButton.bottomlineIcon);
        bottomlineButton.setToolTipText("底線");
        bottomlineButton.setText("bottomline");
        bottomlineButton.setFont(new Font("bottomline",0,0));
        bottomlineButton.addActionListener(new Bottomline(textPane));

        //文字編輯區
        textPane.setFont(new Font("細明體",Font.PLAIN,16));


        JScrollPane panel=new JScrollPane(textPane,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Container contentPane=getContentPane();
        contentPane.add(panel,BorderLayout.CENTER);

        //顯示字數
        stateBar=new JLabel("Characters:"+0);
        stateBar.setHorizontalAlignment(SwingConstants.LEFT);
        textPane.getDocument().addDocumentListener(new WordCountListener(stateBar));
        contentPane.add(stateBar,BorderLayout.SOUTH);









        toolBar.add(newButton);
        toolBar.add(undoButton);
        toolBar.add(boldButton);
        toolBar.add(italicsButton);
        toolBar.add(bottomlineButton);
        toolBar.addSeparator();
        setJMenuBar(menuBar);
        this.add(toolBar, BorderLayout.NORTH);
    }





    @Override
    public void actionPerformed(ActionEvent e) {







    }
}
