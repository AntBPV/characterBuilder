// Prototyping interface
// This interface will allow us to clone existing characters
// from an existing .json file and identify them by adding
// "(CLONE)" to it's name
interface CharacterPrototype{
    // This method will be used inside our main character class
    CharacterPrototype clone();
    public String getClonedName();
    public String getClonedClass();
    public int getClonedStr();
    public int getClonedIntel();
    public int getClonedDex();
    public int getClonedWill();
}

// Character Main Class
// This class has all the attributes, getters and setters
// for the characters
class Character implements CharacterPrototype{
    private String name;
    private String charClass;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int will;

    // Constructor
    public Character(){
        this.name = "Default Name";
        this.charClass = "";
        this.strength = 0;
        this.intelligence = 0;
        this.dexterity = 0;
        this.will = 0;
    }
    public Character(
            String name,
            String charClass,
            int strength,
            int intelligence,
            int dexterity,
            int will
    ){
        this.name = name;
        this.charClass = charClass;
        this.strength = strength;
        this.intelligence=intelligence;
        this.dexterity=dexterity;
        this.will=will;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWill(int will) {
        this.will = will;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCharClass() {
        return charClass;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWill() {
        return will;
    }

    @Override
    public String toString() {
        return "Personaje [Nombre=" + name + ", Clase=" + charClass + " Fuerza= "+strength+" Destreza= "+dexterity+" Inteligencia= "+intelligence+" Voluntad= "+will+"]";
    }

    // Character Prototype methods
    @Override
    public CharacterPrototype clone(){
        name = String.format("%s (CLONED)",this.name);
        return new Character(
                name,
                this.charClass,
                this.strength,
                this.intelligence,
                this.dexterity,
                this.will
        );
    }
    @Override
    public String getClonedName(){
        return this.name;
    }
    @Override
    public String getClonedClass(){
        return this.charClass;
    }
    @Override
    public int getClonedStr(){
        return this.strength;
    }
    @Override
    public int getClonedIntel(){
        return this.intelligence;
    }
    @Override
    public int getClonedDex(){
        return this.dexterity;
    }
    @Override
    public int getClonedWill(){
        return this.will;
    }
}

// Character builder interface
// It will not take an argument for the character class attribute
// instead, each class builder will build it for us.
interface characterBuilder{
    void buildName(String name);
    void buildCharClass();
    void buildStrength(int strength);
    void buildDexterity(int dexterity);
    void buildIntelligence(int intelligence);
    void buildWill(int will);

    Character getCharacter();
}

// All character class builders
// Ln 109:268

// warrior class builder - This class penalizes intelligence
class warriorBuilder implements characterBuilder{
    private Character warrior = new Character();

    // Building name and class
    @Override
    public void buildName(String name){warrior.setName(name);}

    @Override
    public void buildCharClass(){warrior.setCharClass("Guerrero");}

    // Building attributes
    // This is a warrior class so the Strength attribute
    // should have an advantage
    @Override
    public void buildStrength(int strength){
        warrior.setStrength(strength + 5);
    }

    @Override
    public void buildDexterity(int dexterity){
        warrior.setDexterity(dexterity);
    }
    @Override
    public void buildWill(int will){
        warrior.setWill(will);
    }

    // This is a warrior character, so the intelligence attribute
    // should have a penalization
    @Override
    public void buildIntelligence(int intelligence){
        warrior.setIntelligence(intelligence-5);
    }

    // get character
    @Override
    public Character getCharacter(){return warrior;}
}

// mage class builder - This class penalizes strength
class mageBuilder implements characterBuilder{
    private Character mage = new Character();

    // Building name and class
    @Override
    public void buildName(String name){mage.setName(name);}

    @Override
    public void buildCharClass(){mage.setCharClass("Mago");}

    // Building attributes
    // This is a mage character, so the Intelligence attribute
    // should have an advantage
    @Override
    public void buildIntelligence(int intelligence){
        mage.setIntelligence(intelligence+5);
    }

    @Override
    public void buildDexterity(int dexterity){
        mage.setDexterity(dexterity);
    }
    @Override
    public void buildWill(int will){
        mage.setWill(will);
    }

    // This is a mage character, so the strength attribute
    // should have a penalization
    @Override
    public void buildStrength(int strength){
        mage.setStrength(strength-5);
    }

    // get character
    @Override
    public Character getCharacter(){return mage;}
}

// Rogue class builder - This class penalizes will
class rogueBuilder implements characterBuilder{
    private Character rogue = new Character();

    // Building name and class
    @Override
    public void buildName(String name){rogue.setName(name);}

    @Override
    public void buildCharClass(){rogue.setCharClass("Picaro");}

    // Building attributes
    // This is a rogue character, so the Dexterity attribute
    // should have an advantage
    @Override
    public void buildDexterity(int dexterity){
        rogue.setDexterity(dexterity+5);
    }

    @Override
    public void buildStrength(int strength){
        rogue.setStrength(strength);
    }
    @Override
    public void buildIntelligence(int intelligence){
        rogue.setIntelligence(intelligence);
    }

    // This is a mage character, so the strength attribute
    // should have a penalization
    @Override
    public void buildWill(int will){
        rogue.setWill(will-5);
    }

    // get character
    @Override
    public Character getCharacter(){return rogue;}
}

// Druid class builder - This class penalizes will
class druidBuilder implements characterBuilder{
    private Character druid = new Character();

    // Building name and class
    @Override
    public void buildName(String name){druid.setName(name);}

    @Override
    public void buildCharClass(){druid.setCharClass("Druida");}

    // Building attributes
    // This is a druid character, so the Will attribute
    // should have an advantage
    @Override
    public void buildWill(int will){
        druid.setWill(will+5);
    }

    @Override
    public void buildStrength(int strength){
        druid.setStrength(strength);
    }
    @Override
    public void buildIntelligence(int intelligence){
        druid.setIntelligence(intelligence);
    }

    // This is a mage character, so the strength attribute
    // should have a penalization
    @Override
    public void buildDexterity(int dexterity){
        druid.setDexterity(dexterity-5);
    }

    // get character
    @Override
    public Character getCharacter(){return druid;}
}


