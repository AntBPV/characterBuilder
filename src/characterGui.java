import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class characterGui extends JFrame {
    // Input Text Fields
    private JTextField nameTextField;
    // Attributes Text Fields - Non-editable
    private JTextField strengthTextField, dexterityTextField, intelTextField, willTextField;
    private JTextField apTextField;

    // Attributes Buttons
    private JButton decreaseStrButton, increaseStrButton;
    private JButton decreaseDexButton, increaseDexButton;
    private JButton decreaseIntButton, increaseIntButton;
    private JButton decreaseWillButton, increaseWillButton;

    // Action buttons
    private JButton saveButton, cancelButton, openButton, cloneButton;

    // File chooser
    private JFileChooser fileChooser;
    JSONObject characterObject;

    // Combo box
    private JComboBox<String> classBox;

    // Gui Panel
    private JPanel characterPanel;

    // Gui Builder
    public characterGui(){
        setTitle("Creador de personajes");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src/assets"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Json files", "json"));

        setContentPane(characterPanel);
        addFunctions();
    }

    // Custom ui components
    private void createUIComponents() {
        // Class box for class choosing
        classBox = new JComboBox<String>();
        classBox.addItem("Guerrero");
        classBox.addItem("Mago");
        classBox.addItem("Picaro");
        classBox.addItem("Druida");

    }

    // Adding functionality method
    private void addFunctions(){
        addDecreaseFunctions();
        addIncreaseFunctions();
        addComboBoxFunctions();
        addCancelFunction();
        addSaveFunction();
        addOpenFunction();
        addCloneFunction();
    }

    // Increase and decrease attributes by clicking on buttons
    private void addDecreaseFunctions(){
        // Strength
        decreaseStrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(strengthTextField.getText());
                int points = Integer.parseInt(apTextField.getText());
                value = value-1;
                points = points+1;
                strengthTextField.setText(Integer.toString(value));
                apTextField.setText(Integer.toString(points));
            }
        });

        // Intelligence
        decreaseIntButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(intelTextField.getText());
                int points = Integer.parseInt(apTextField.getText());
                value = value-1;
                points = points+1;
                intelTextField.setText(Integer.toString(value));
                apTextField.setText(Integer.toString(points));
            }
        });

        // Dexterity
        decreaseDexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(dexterityTextField.getText());
                int points = Integer.parseInt(apTextField.getText());
                value = value-1;
                points = points+1;
                dexterityTextField.setText(Integer.toString(value));
                apTextField.setText(Integer.toString(points));
            }
        });

        // Will
        decreaseWillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(willTextField.getText());
                int points = Integer.parseInt(apTextField.getText());
                value = value-1;
                points = points+1;
                willTextField.setText(Integer.toString(value));
                apTextField.setText(Integer.toString(points));
            }
        });
    }
    private void addIncreaseFunctions(){
        // Strength
        increaseStrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int points = Integer.parseInt(apTextField.getText());
                if(points==0)return;

                int value = Integer.parseInt(strengthTextField.getText());
                value = value+1;
                points = points-1;
                strengthTextField.setText(Integer.toString(value));
                apTextField.setText(Integer.toString(points));
            }
        });

        // Intelligence
        increaseIntButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int points = Integer.parseInt(apTextField.getText());
                if(points==0)return;

                int value = Integer.parseInt(intelTextField.getText());
                value = value+1;
                points = points-1;
                intelTextField.setText(Integer.toString(value));
                apTextField.setText(Integer.toString(points));
            }
        });

        // Dexterity
        increaseDexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int points = Integer.parseInt(apTextField.getText());
                if(points==0)return;

                int value = Integer.parseInt(dexterityTextField.getText());
                value = value+1;
                points = points-1;
                dexterityTextField.setText(Integer.toString(value));
                apTextField.setText(Integer.toString(points));
            }
        });

        // Will
        increaseWillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int points = Integer.parseInt(apTextField.getText());
                if(points==0)return;

                int value = Integer.parseInt(willTextField.getText());
                value = value+1;
                points = points-1;
                willTextField.setText(Integer.toString(value));
                apTextField.setText(Integer.toString(points));
            }
        });
    }

    // Change attributes values by combo box item
    private void addComboBoxFunctions(){
        classBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) classBox.getSelectedItem();
                switch (selectedClass){
                    case "Guerrero":
                        characterBuilder warrior = new warriorBuilder();
                        warrior.buildStrength(0);
                        warrior.buildIntelligence(0);
                        int strWarriorValue = warrior.getCharacter().getStrength();
                        int intelWarriorValue = warrior.getCharacter().getIntelligence();
                        strengthTextField.setText(Integer.toString(strWarriorValue));
                        intelTextField.setText(Integer.toString(intelWarriorValue));
                        dexterityTextField.setText("0");
                        willTextField.setText("0");
                        apTextField.setText("7");
                        break;
                    case "Mago":
                        characterBuilder mage = new mageBuilder();
                        mage.buildStrength(0);
                        mage.buildIntelligence(0);
                        int strMageValue = mage.getCharacter().getStrength();
                        int intelMageValue = mage.getCharacter().getIntelligence();
                        strengthTextField.setText(Integer.toString(strMageValue));
                        intelTextField.setText(Integer.toString(intelMageValue));
                        dexterityTextField.setText("0");
                        willTextField.setText("0");
                        apTextField.setText("7");
                        break;
                    case "Picaro":
                        characterBuilder rogue = new rogueBuilder();
                        rogue.buildWill(0);
                        rogue.buildDexterity(0);
                        int dexRogueValue = rogue.getCharacter().getDexterity();
                        int willRogueValue = rogue.getCharacter().getWill();
                        strengthTextField.setText("0");
                        intelTextField.setText("0");
                        dexterityTextField.setText(Integer.toString(dexRogueValue));
                        willTextField.setText(Integer.toString(willRogueValue));
                        apTextField.setText("7");
                        break;
                    case "Druida":
                        characterBuilder druid = new druidBuilder();
                        druid.buildWill(0);
                        druid.buildDexterity(0);
                        int dexDruidValue = druid.getCharacter().getDexterity();
                        int willDruidValue = druid.getCharacter().getWill();
                        strengthTextField.setText("0");
                        intelTextField.setText("0");
                        dexterityTextField.setText(Integer.toString(dexDruidValue));
                        willTextField.setText(Integer.toString(willDruidValue));
                        apTextField.setText("7");
                        break;
                    default:
                        System.out.println("Error: Clase no existente");
                        break;
                }
            }
        });
    }

    // Cancel and save characters
    private void addCancelFunction(){
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTextField.setText("");
                classBox.setSelectedItem("Guerrero");
                strengthTextField.setText("0");
                intelTextField.setText("0");
                dexterityTextField.setText("0");
                willTextField.setText("0");
            }
        });
    }
    private void addSaveFunction(){
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creating Json object to save
                characterObject = new JSONObject();

                //Inserting key-value pairs into the object
                String name = (String) nameTextField.getText();
                String charClass = (String) classBox.getSelectedItem();
                String strength = (String) strengthTextField.getText();
                String intelligence = (String) intelTextField.getText();
                String dexterity = (String) dexterityTextField.getText();
                String will = (String) willTextField.getText();

                switch (charClass){
                    case "Guerrero":
                        characterBuilder warrior = new warriorBuilder();
                        warrior.buildName(name);
                        warrior.buildCharClass();
                        // Since this is a warrior, we want to build the strength
                        // without the advantage so the builder can put it in
                        warrior.buildStrength(Integer.valueOf(strength)-5);

                        // Also we want to remove the penalization on intelligence
                        warrior.buildIntelligence(Integer.valueOf(intelligence)+5);

                        // Other attributes go the same
                        warrior.buildDexterity(Integer.valueOf(dexterity));
                        warrior.buildWill(Integer.valueOf(will));

                        Character userWarriorCharacter = warrior.getCharacter();
                        System.out.println(userWarriorCharacter);
                        break;
                    case "Mago":
                        characterBuilder mage = new mageBuilder();
                        mage.buildName(name);
                        mage.buildCharClass();
                        // Since this is a warrior, we want to build the intelligence
                        // without the advantage so the builder can put it in
                        mage.buildIntelligence(Integer.valueOf(intelligence)-5);

                        // Also we want to remove the penalization on strength
                        mage.buildStrength(Integer.valueOf(strength)+5);

                        // Other attributes go the same
                        mage.buildDexterity(Integer.valueOf(dexterity));
                        mage.buildWill(Integer.valueOf(will));

                        Character userMageCharacter = mage.getCharacter();
                        System.out.println(userMageCharacter);
                        break;
                    case "Picaro":
                        characterBuilder rogue = new rogueBuilder();
                        rogue.buildName(name);
                        rogue.buildCharClass();
                        // Since this is a rogue, we want to build the dexterity
                        // without the advantage so the builder can put it in
                        rogue.buildDexterity(Integer.valueOf(dexterity)-5);

                        // Also we want to remove the penalization on will
                        rogue.buildWill(Integer.valueOf(will)+5);

                        // Other attributes go the same
                        rogue.buildIntelligence(Integer.valueOf(intelligence));
                        rogue.buildStrength(Integer.valueOf(strength));

                        Character userRogueCharacter = rogue.getCharacter();
                        System.out.println(userRogueCharacter);
                        break;
                    case "Druida":
                        characterBuilder druid = new druidBuilder();
                        druid.buildName(name);
                        druid.buildCharClass();
                        // Since this is a rogue, we want to build the dexterity
                        // without the advantage so the builder can put it in
                        druid.buildWill(Integer.valueOf(will)-5);

                        // Also we want to remove the penalization on will
                        druid.buildDexterity(Integer.valueOf(dexterity)+5);

                        // Other attributes go the same
                        druid.buildIntelligence(Integer.valueOf(intelligence));
                        druid.buildStrength(Integer.valueOf(strength));

                        Character userDruidCharacter = druid.getCharacter();
                        System.out.println(userDruidCharacter);
                        break;
                }

                characterObject.put("Name", name);
                characterObject.put("Class", charClass);
                characterObject.put("Strength", strength);
                characterObject.put("Intelligence", intelligence);
                characterObject.put("Dexterity", dexterity);
                characterObject.put("Will", will);

                // open save dialog
                int result = fileChooser.showSaveDialog(characterGui.this);

                // Continue to execute code only if the user pressed the save button
                if(result != JFileChooser.APPROVE_OPTION) return;
                try {
                    File selectedFile = fileChooser.getSelectedFile();

                    String fileName = selectedFile.getName();
                    if(!fileName.substring(fileName.length()-4).equalsIgnoreCase(".json")){
                        selectedFile = new File(selectedFile.getAbsoluteFile()+ ".json");
                    }

                    FileWriter file = new FileWriter(selectedFile);
                    file.write(characterObject.toJSONString());
                    file.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    // Open and read json files
    private void addOpenFunction(){
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONParser parser = new JSONParser();
                int result = fileChooser.showOpenDialog(characterGui.this);

                if(result != JFileChooser.APPROVE_OPTION) return;
                try {
                    File selectedFile = fileChooser.getSelectedFile();
                    Object obj = parser.parse(new FileReader(selectedFile));
                    JSONObject jsonObject = (JSONObject)obj;
                    String name = (String)jsonObject.get("Name");
                    String charClass = (String)jsonObject.get("Class");
                    String strength = (String)jsonObject.get("Strength");
                    String intelligence = (String)jsonObject.get("Intelligence");
                    String dexterity = (String)jsonObject.get("Dexterity");
                    String will = (String)jsonObject.get("Will");

                    nameTextField.setText(name);
                    classBox.setSelectedItem(charClass);
                    strengthTextField.setText(strength);
                    intelTextField.setText(intelligence);
                    dexterityTextField.setText(dexterity);
                    willTextField.setText(will);
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
    private void addCloneFunction(){
        cloneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONParser parser = new JSONParser();
                int result = fileChooser.showOpenDialog(characterGui.this);

                if(result != JFileChooser.APPROVE_OPTION) return;
                try {
                    File selectedFile = fileChooser.getSelectedFile();
                    Object obj = parser.parse(new FileReader(selectedFile));
                    JSONObject jsonObject = (JSONObject)obj;
                    String name = (String)jsonObject.get("Name");
                    String charClass = (String)jsonObject.get("Class");
                    String strength = (String)jsonObject.get("Strength");
                    String intelligence = (String)jsonObject.get("Intelligence");
                    String dexterity = (String)jsonObject.get("Dexterity");
                    String will = (String)jsonObject.get("Will");

                    // Creating character to be cloned
                    CharacterPrototype originalCharacter = new Character(
                            name,
                            charClass,
                            Integer.parseInt(strength),
                            Integer.parseInt(intelligence),
                            Integer.parseInt(dexterity),
                            Integer.parseInt(will)
                    );
                    // Clone character
                    CharacterPrototype cloned = originalCharacter.clone();

                    nameTextField.setText(cloned.getClonedName());
                    classBox.setSelectedItem(cloned.getClonedClass());
                    strengthTextField.setText(String.valueOf(cloned.getClonedStr()));
                    intelTextField.setText(String.valueOf(cloned.getClonedIntel()));
                    dexterityTextField.setText(String.valueOf(cloned.getClonedDex()));
                    willTextField.setText(String.valueOf(cloned.getClonedWill()));
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
