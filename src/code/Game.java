package code;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The main class of the game. When a new game is created and launched, the user
 * appears in a room and the main quest is activated. 
 * All other constructors are called
 *
 * @author (Grp5)
 * @version (V5-13/12/2017)
 */
public class Game {

    private Interface gui;
    // this attribute represents the current room in which the player is located.
    protected Room currentRoom;
    // this attribute represents the player 
    protected Player thePlayer;
    //random events that can happen
    RandomEvent event;
    //a character used to get the entries by the user
    char character;

    //dialogue attribute to be able to call the dialogues for the NPCs
    protected Dialogue dialogue;

    //an int used for the choices
    private int n = -1;
    //boolean used to display the NPCs during the random events
    private boolean allanThere;
    private boolean lucThere;
    private boolean pillowThere;
    private boolean penguinThere;

    private HashMap<Room, String> minimap;

    // arraylist used to display the instructions of the quests
    private ArrayList<String> instructions;
    // Iterator to browse the quests
    protected int currentQuest = 0;

    //NPCs
    private NPC axel;
    private NPC PGTD;
    private NPC nolan;
    private NPC martin;
    private NPC annie;
    private NPC guardian;
    private NPC M2;
    private NPC valentin;
    private NPC thomas;
    private NPC morgane;
    private NPC marie;
    private NPC clement;
    private NPC PGEnd;

    //items
    private Container cafet;
    private SimpleObject coca;
    private SimpleObject icetea;
    private SimpleObject kinderbueno;
    private SimpleObject croissant;
    private Container annieDesk;
    private SimpleObject pgDesk;
    private SimpleObject board;
    private Container couch;
    private Container deskTp1;
    private SimpleObject computer;
    private Container wardrobe;
    private SimpleObject tissue;
    private SimpleObject diploma;
    private SimpleObject liftButton;
    private SimpleObject stairs;
    private SimpleObject key;

    // All the rooms for the B2 building where the game is set
    Room annieOffice, classRoom, downstairsCorridor1, downstairsCorridor2, upstairsCorridor1, upstairsCorridor2, upStairs, downStairs, pgOffice, tp1, td1, td4, wc, hall, theatre, downstairsLift, upstairsLift, restRoom;

    /**
     * Constructor for objects of class Game it initialises the different
     * parameters for the game
     *
     *
     * @param playerChoice an int that defines which character you want to play with
     * @param w takes the interface to be able to display it during the game
     */
    public Game(int playerChoice, Interface w) {
        gui = w;

        choosePlayer(playerChoice); 
        event = new RandomEvent(thePlayer);

        //NPCs
        axel = new NPC("Axel", false, false);
        nolan = new NPC("Nolan", true, false);
        martin = new NPC("Martin", true, false);
        annie = new NPC("Mrs Geniet", true, false);
        guardian = new NPC("Guardian", true, false);
        M2 = new NPC("M2", true, false);
        valentin = new NPC("Valentin", true, false);
        thomas = new NPC("Thomas", true, false);
        morgane = new NPC("Morgane", true, false);
        marie = new NPC("Marie", true, false);
        clement = new NPC("Clément", true, false);
        PGTD = new NPC("PGTD", true, false);
        PGEnd = new NPC("PGEnd", true, false);

        //items for the rooms
        cafet = new Container("cafet", false);
        coca = new SimpleObject("coca", false);
        icetea = new SimpleObject("icetea", false);
        kinderbueno = new SimpleObject("kinderbueno", false);
        croissant = new SimpleObject("croissant", false);
        cafet.addObject(coca);
        cafet.addObject(icetea);
        cafet.addObject(kinderbueno);
        cafet.addObject(croissant);
        annieDesk = new Container("desk in Mrs Geniet's office", false);
        diploma = new SimpleObject("Martin's diploma", false);
        annieDesk.addObject(diploma);
        pgDesk = new SimpleObject("desk in PG's office", false);
        board = new SimpleObject("board", false);
        couch = new Container("couch", false);
        deskTp1 = new Container("desk", false);
        computer = new SimpleObject("computer", true);
        deskTp1.addObject(computer);
        wardrobe = new Container("wardrobe", false);
        tissue = new SimpleObject("tissue", false);
        key = new SimpleObject("key", true);
        wardrobe.addObject(tissue);
        wardrobe.addObject(key);
        liftButton = new SimpleObject("button", false);
        stairs = new SimpleObject("stairs", false);

        dialogue = new Dialogue();

        //intsructions given to the player to help him navigate throughout the game
        instructions = new ArrayList<>();
        instructions.add("You see someone coming to talk to you. It's your old friend, Axel.");
        instructions.add("You must look for PG so you can get your COOPOO project");
        instructions.add("You must find your two friends, Martin and Nolan, so they can help you on your project.");
        instructions.add("You must find your friend Martin so he can help you on your project.");
        instructions.add("You must get Martin his diploma for him to help you.");
        instructions.add("You must find your friend Nolan so he can help you on your project.");
        instructions.add("You must get Nolan out of the toilets!");
        instructions.add("You must code your project with Nolan and Martin.");
        instructions.add("You must give your project back to PG.");

    }

    /**
     * Method choosePlayer allows to chose between three types of player
     * they differ by their stat and their special ability
     * @param player integer
     */
    public void choosePlayer(int player) {
        // the constructor will define which player the user has chosen
        switch (player) {
            case 1:
                thePlayer = new TypeOne();
                break;
            case 2:
                thePlayer = new TypeTwo();
                break;
            case 3:
                thePlayer = new TypeThree();
                break;
            default:
                System.err.println("Error : player type must be 1, 2 or 3. Please report");
                break;
        }
    }

    /**
     * Method getInformationPlayer. Displays all the information and statistics
     * about the player
     *
     */
    public void getInformationPlayer() {
        Interface.setDialog("Your stats:");
        Interface.setDialog("You have " + thePlayer.getStrStat() + " strength");
        Interface.setDialog("You have " + thePlayer.getStaStat() + " stamina");
        Interface.setDialog("You have " + thePlayer.getIntStat() + " intelligence");
        Interface.setDialog("You have " + thePlayer.getStressStat() + " stress");
        Interface.setDialog("You have " + thePlayer.getSpeStat() + " speech");
        Interface.setDialog("You have " + thePlayer.getMoney() + " money");
        if (!thePlayer.getCrowbar()) {
            Interface.setDialog("You aren't carrying anything special, except for your papers and stuff.");
        } else {
            Interface.setDialog("You have your crowbar in your inventory. You love that thing.");
        }

    }

    /**
     * Method createRooms is used to create the rooms of the game, it initialize
     * them with a name and a description
     */
    public void createRooms() {

        // For the map display
        minimap = new HashMap<Room, String>();

        // create the rooms
        downstairsCorridor1 = new Room("Corridor down1", "A corridor in the b2 building.");
        downstairsCorridor2 = new Room("Corridor down2", "Another corridor.");
        upstairsCorridor1 = new Room("Corridor upstairs1", "A corridor in the b2 building, on the first floor.");
        upstairsCorridor2 = new Room("Corridor upstairs2", "Another corridor, on the first floor.");
        downstairsLift = new Room("Lift down", "The lift (elevator). You are level 1 (downstairs)");
        upstairsLift = new Room("Lift up", "The lift which connects the two levels. You are level 2 (upstairs).");
        annieOffice = new Room("Mrs. Geniet's Office", "The office of Mrs. Geniet, the teacher of all GPhy students..");
        downStairs = new Room("Staircase down", "The stairs that connect the two levels together. Climbing them can get exhausting.");
        classRoom = new Room("Classroom", "The classroom where the main courses are.");
        upStairs = new Room("Staircase up", "You are at the top of the staircase.");
        pgOffice = new Room("Mr. Girard's Office", "The big bo$$");
        restRoom = new Room("Resting room", "A room for resting with sofas and coffee.");
        theatre = new Room("Amphitheatre", "The amphitheatre where the oral presentations are being held.");
        hall = new Room("B2 entrance", "The entrance of the b2 building.");
        tp1 = new Room("TP1", "A classroom with and lot of computers, for practical exercises.");
        td1 = new Room("TD1", "A fairly small classroom.");
        td4 = new Room("TD4", "A small classroom.");
        wc = new Room("WC", "The toilets of the building.");

        // Set the room exits. The order is north - east - south - west (clockwise)
        // First floor
        theatre.setExits(null, hall, null, null);
        hall.setExits(downstairsLift, downstairsCorridor1, null, theatre);
        downstairsLift.setExits(null, null, hall, null);
        downstairsCorridor1.setExits(td1, downstairsCorridor2, annieOffice, hall);
        td1.setExits(null, null, downstairsCorridor1, null);
        td4.setExits(null, null, downstairsCorridor2, null);
        annieOffice.setExits(downstairsCorridor1, null, null, null);
        downstairsCorridor2.setExits(td4, downStairs, pgOffice, downstairsCorridor1);
        pgOffice.setExits(downstairsCorridor2, null, null, null);
        downStairs.setExits(null, null, null, downstairsCorridor2);
        // Second floor (upstairs). See map in shared google drive folder
        wc.setExits(null, upstairsCorridor1, null, null);
        upstairsCorridor1.setExits(upstairsLift, upstairsCorridor2, tp1, wc);
        upstairsLift.setExits(null, null, upstairsCorridor1, null);
        tp1.setExits(upstairsCorridor2, restRoom, null, null);
        upstairsCorridor2.setExits(classRoom, upStairs, tp1, upstairsCorridor1);
        classRoom.setExits(null, null, upstairsCorridor2, null);
        restRoom.setExits(upStairs, null, null, tp1);
        upStairs.setExits(null, null, restRoom, upstairsCorridor2);

        minimap.put(theatre, "Lecture theatre");
        minimap.put(hall, "Hall");
        minimap.put(downstairsLift, "Lift");
        minimap.put(upstairsLift, "Lift");
        minimap.put(downstairsCorridor1, "Corridor");
        minimap.put(downstairsCorridor2, "Corridor");
        minimap.put(upstairsCorridor1, "Corridor");
        minimap.put(upstairsCorridor2, "Corridor");
        minimap.put(td1, "TD 1");
        minimap.put(td4, "TD 4");
        minimap.put(tp1, "TP 1");
        minimap.put(downStairs, "Staircase");
        minimap.put(upStairs, "Staircase");
        minimap.put(annieOffice, "Mrs. Geniet's Office");
        minimap.put(wc, "WC");
        minimap.put(classRoom, "Classroom");
        minimap.put(restRoom, "Resting Room");

        currentRoom = hall;  // The game starts with he player located in the hall.

    }

    /**
     * Method addItems is used to add all the items in the specific rooms
     */
    public void addItems() {
        //items for the hall
        hall.addItem(axel);
        hall.addItem(cafet);
        //items for the theatre
        theatre.addItem(annie);
        theatre.addItem(marie);
        //items for the lift
        downstairsLift.addItem(guardian);
        upstairsLift.addItem(guardian);
        downstairsLift.addItem(liftButton);
        upstairsLift.addItem(liftButton);
        //items for annie's Office
        annieOffice.addItem(annieDesk);
        //items for PG's office
        pgOffice.addItem(pgDesk);
        pgOffice.addItem(PGEnd);
        //items for TD4
        td4.addItem(board);
        td4.addItem(PGTD);
        //items for TD1
        td1.addItem(thomas);
        //items for wc
        wc.addItem(nolan);
        //items for restingroom
        restRoom.addItem(couch);
        //items for TP1
        tp1.addItem(martin);
        tp1.addItem(wardrobe);
        tp1.addItem(deskTp1);
        tp1.addItem(valentin);
        //items for the stairs
        downStairs.addItem(morgane);
        downStairs.addItem(stairs);
        upStairs.addItem(stairs);
        //items for the classroom
        classRoom.addItem(clement);
        //items for corridor upstairs
        upstairsCorridor1.addItem(M2);
    }

    /**
     * allows the player to change room, depends on the exits that exists in the
     * current room. Depends on what character the player types : N, S, E, W
     * when the player enter in the new room, depending of the room, some random
     * event can appear
     *
     * @param direction The direction in which the player is trying to go.
     **/
    public void changeRoom(String direction) {
        Room nextRoom = null;
        // Planning to go to the next room. (hashmap browsing) 
        nextRoom = currentRoom.getExits().get(direction);

        if (nextRoom == null) {
            Interface.setDialog("You can't go this way.");
        } else {
            // Moving to the next room

            if ((currentRoom == downstairsCorridor1) && (nextRoom == annieOffice)) {
                if (!thePlayer.getKeyAnnie()) {
                    Interface.setDialog("This office is locked, you need a key to open it...");
                } else {
                    currentRoom = nextRoom;
                    gui.refresh();
                }
            } else if ((currentRoom == downstairsCorridor2) && (nextRoom == pgOffice)) {
                if (!key.getDisappeared()) {
                    Interface.setDialog("This office is locked, you need a key to open it...");
                } else {
                    currentRoom = nextRoom;
                    gui.refresh();
                }
            } else {
                currentRoom = nextRoom;
                gui.refresh();
            }
            Interface.setDialog("\n" + "Current location : \t " + currentRoom.getName());
            Interface.setDialog("" + currentRoom.getDescription());

            //random events that can appear in the corridors
            if ((currentRoom == upstairsCorridor2) || (currentRoom == upstairsCorridor1) || (currentRoom == downstairsCorridor1) || (currentRoom == downstairsCorridor2)) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 20);
                rEvent(randomNum);

            }
        }
    }

    /**
     * method that uses the randomInt attribute to call randomly a method in the
     * RandomEvent class (each number is linked to a method in RandomEvent)
     *
     * @param randomInt a random integer that allow to know if a randomEvent will appear
     */
    public void rEvent(int randomInt) {
        switch (randomInt) {
            case 2:
                event.hiddenCandy();
                gui.refresh();
                break;
            case 3:
                allanThere = true;
                event.allanJoke();
                gui.refresh();
                break;
            case 4:
                pillowThere = true;
                event.pillowAttack();
                gui.refresh();
                break;
            case 5:
                lucThere = true;
                event.adaHelp();
                gui.refresh();
                break;
            case 6:
                penguinThere = true;
                event.penguinHug();
                gui.refresh();
                break;
            case 7:
                event.teacherMeeting();
                gui.refresh();
                break;
            case 8:
                event.conversation();
                gui.refresh();
                break;
        }
    }

    /**
     * Method explore allow knowing the item on the current room
     *
     */
    public void explore() {
        currentRoom.printItems();
    }

    /**
     * Method interact allow interacting with the item of the room if it is
     * possible.
     * Check if a room is empty
     * Check if the item is lock
     *
     */
    public void interact() {

        if (!currentRoom.listRoomItem.isEmpty()) {
            Interface.setDialog("What item do you want to interact with ?");
            currentRoom.printItems();
        } else {
            Interface.setDialog("There is nothing to interact with in this room...");
        }
    }

    /**
     * Print out some help information. Contains all the information the user
     * needs to know about the game.
     * @param q is int 
     */
    public void printHelp(int q) {
        Interface.setDialog("__________________HELP___________________");
        Interface.setDialog("You are wandering in the B2 building.");
        Interface.setDialog("Your goal is to deliver a project.");
        Interface.setDialog("You can move, and interact with te world.");
        Interface.setDialog("hand buttons:  go north");
        Interface.setDialog("\t\tgo east");
        Interface.setDialog("\t\tgo south");
        Interface.setDialog("\t\tgo west");
        Interface.setDialog("question mark button: \t\thelp, duh");
        Interface.setDialog("X mark button: \t\tquit");
        Interface.setDialog("open hand button: \t\tInteract");
        Interface.setDialog("Star button : special power");
        Interface.setDialog("_________________________________________");
        Interface.setDialog("You are playing with the character : " + thePlayer.getNamePlayer());
        Interface.setDialog("You are in : " + currentRoom.getName());
        Interface.setDialog("" + instructions.get(q));

    }

    /**
     * Print out some welcome text. Contains all the information the user needs
     * to know about the game.
     */
    public void printWelcome() {
        Interface.setDialog("\n\n\n");
        Interface.setDialog("<////////////////////////////////[]========0");
        Interface.setDialog("\n");
        Interface.setDialog("_________\\/\\/ O R L D 0 F Z U U L___________");
        Interface.setDialog("\n");
        Interface.setDialog("0========[]\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\>\n\n\n");
        Interface.setDialog("Welcome to World of Zuul.");
        Interface.setDialog("You have to deliver a COOPOO project");
        Interface.setDialog("on time to the evil lord PG.");
        Interface.setDialog("May the odds be with you.");
        Interface.setDialog("_________________________________________");
        Interface.setDialog("Press any key to enter the beautiful world of Zuul...");
    }

    /**
     * allows the player to quit the game
     * return a boolean.
     * If yes, leave the game.
     * @return a boolean if you want to quit
     */
    public boolean quit() {
        Interface.setDialog("Are you sure? [Y/N]");
        char character;
        Scanner reader;
        reader = new Scanner(System.in);
        character = reader.next().charAt(0);
        if ((character != 'y') && (character != 'Y')) {
            Interface.setDialog("Thought so.");
            return (false);
        } else {
            Interface.setDialog("Hope you had a good time.");
            return (true);
        }

    }

    /**
     * getItem method, allowing to access items in a room.
     * @param name is the name of the item 
     * @return an Item object.
     * By default, return martin Item.
     */
    public Item getItem(String name) {
        int i;
        String n;
        for (i = 0; i < currentRoom.listRoomItem.size(); i++) {
            n = currentRoom.listRoomItem.get(i).getName();
            if (name.equals(n)) {
                return currentRoom.listRoomItem.get(i);
            }
        }
        return martin;
    }

    /**
     * getPlayer method. Get thePlayer attribute, being a Player object.
     * @return thePlayer, a Player Object.
     */
    public Player getPlayer() {
        return thePlayer;
    }

    /**
     * getGui method. Get gui attribute, being an Interface object.
     * @return gui, an Interface Object.
     */
    public Interface getGui() {
        return gui;
    }

    /**
     * isAllanThere method. Get the boolean allanThere
     * @return allanThere, a boolean
     */
    public boolean isAllanThere() {
        return allanThere;
    }
    
    
    /**
     * isLucThere method. Get the boolean LucThere
     * @return lucThere, a boolean
     */
    public boolean isLucThere() {
        return lucThere;
    }

    /**
     * afterInteract method. Allows to interact with an item chosen in the current room.
     * A tab containing all the items of the current room is called. 
     * With a loop, search the selected item (choiceInteract) into the tab.
     * @param choiceInteract is the number of the interaction
     *  
     */
    public void afterInteract(int choiceInteract) {
        n = choiceInteract;
        // Player wishes to interact with object of index i
        for (int i = 0; i < currentRoom.listRoomItem.size(); i++) {
            if (n == i) {
                Interface.setDialog("You are interacting with the item " + currentRoom.listRoomItem.get(i).itemName);
                currentRoom.listRoomItem.get(i).setInteracting(true); //you are interacting with the NPC so he appears on the screen
                gui.refresh(); //refresh the interface
                dialogue.setChoice(n);
                currentRoom.listRoomItem.get(i).interactItem();

                if (dialogue.getStressDialogue() != 0) {

                    thePlayer.addStat("stressStat", currentRoom.listRoomItem.get(i).dialogue.getStressDialogue());
                    gui.refresh(); //refresh the interface
                }

                //if the NPC is not locked, you can have an important conversation
                if (!currentRoom.listRoomItem.get(i).getLock()) {
                    switch (currentRoom.listRoomItem.get(i).getName()) {
                        case ("Axel"):
                            //at the end of the conversation, you have all the information you need, axel does not talk to you about that again
                            axel.setLock(true);
                            PGTD.setLock(false);
                            currentQuest = 1;
                            break;
                        case ("PGTD"):
                            PGTD.setLock(true);
                            PGTD.setHasDisappeared(true); //goes away
                            nolan.setLock(false); //Conversation with Nolan in the toilet is available
                            martin.setLock(false); //Conversation with Martin about the diploma is available
                            currentQuest = 2;
                            break;
                        case ("Martin"):
                            annie.setLock(false); //unlocks conversation with annie in the theatre
                            martin.setLock(true);
                            nolan.setLock(true); //locks Nolan until you finish the quests
                            nolan.setHasDisappeared(true);
                            currentQuest = 4;
                            break;
                        case ("Nolan"):
                            guardian.setLock(false);
                            nolan.setLock(true);
                            currentQuest = 6;
                            break;
                        case ("Mrs Geniet"):
                            annie.setLock(true); //locks annie again
                            thePlayer.setKeyAnnie(true); //you get the key to open the door, unlocks the door to her office, you can get the diploma and then go back to Martin
                            break;
                        case ("Guardian"):
                            guardian.setLock(true);
                            thePlayer.setCrowbar(true); //you get the crowbar that will allow you to open the door for Nolan
                            break;
                        default:
                            break;
                    }
                    currentRoom.listRoomItem.get(i).setInteracting(false);
                    gui.refresh();
                } else if (currentRoom.listRoomItem.get(i).getLock()) { //the NPC is locked
                    switch (currentRoom.listRoomItem.get(i).getName()) {
                        case "Nolan":
                            if (thePlayer.getCrowbar()) //if you talked to the guardian
                            {
                                Interface.setDialog("[Nolan] Oh my god thanks, i thought I would be locked in here forever!");
                                if (diploma.getLock()) //if you haven't finished the quests with martin
                                {
                                    Interface.setDialog("[Nolan] Now you need to find Martin so that we can finish this project!");
                                    currentQuest = 3;
                                    martin.setLock(false);
                                } else {
                                    Interface.setDialog("[Nolan] Oh you have found Martin? Ok, let's go finish this project!");
                                    Interface.setDialog("[Nolan] Let's Go to TP1 to use the computer");
                                    computer.setLock(false);
                                    currentQuest = 7;
                                }
                            }
                            break;
                        case "Martin":
                            if (!diploma.isLock) { // if you have the diploma
                                Interface.setDialog("[Martin] Oh thanks for my diploma, I owe you one!");
                                if (!thePlayer.getCrowbar()) { //if you haven't finished the quests with Nolan
                                    Interface.setDialog("[Martin] Now we need Nolan and we can start coding, so we can be home before midnight");
                                    currentQuest = 5;
                                    nolan.setLock(false);
                                    nolan.setHasDisappeared(false);
                                } else {
                                    if (!computer.getDisappeared()) {
                                        Interface.setDialog("[Martin] I saw Nolan, he said that you helped him, so now we are ready to code! Use the computer in this room");
                                        computer.setLock(false);
                                        currentQuest = 7;
                                    } else {
                                        PGEnd.setLock(false);
                                        key.setLock(false);
                                        currentQuest = 8;
                                        Interface.setDialog("[Martin] Good job team! Now we need to hand it over to PG... I think you should do it, as you are the one that less worked!");
                                    }
                                }
                            }
                            break;
                        default:
                            break;
                    }

                }

                //if you interact with the buttons in the lift then you change floors
                if (currentRoom.listRoomItem.get(i) == liftButton) {
                    //allows to go upstairs

                    if (currentRoom == upstairsLift) {
                        currentRoom = downstairsLift;
                        Interface.setDialog("The lift is going down!");
                        Interface.setDialog("\n" + currentRoom.getDescription());
                    } else if (currentRoom == downstairsLift) {
                        currentRoom = upstairsLift;
                        Interface.setDialog("The lift is going up!");
                        Interface.setDialog("\n" + currentRoom.getDescription());
                    }
                }
                //if you interact with the stairs then you change floors
                if (currentRoom.listRoomItem.get(i) == stairs) {
                    //allows to go upstairs

                    if (currentRoom == upStairs) {
                        currentRoom = downStairs;
                        Interface.setDialog("You are going down the stairs!");
                        Interface.setDialog("\n" + currentRoom.getDescription());
                    } else if (currentRoom == downStairs) {
                        currentRoom = upStairs;
                        Interface.setDialog("You are climbing the stairs!");
                        Interface.setDialog("\n" + currentRoom.getDescription());
                    }
                }
            }
        }
    }

    /**
     * getDialogue method. allows to return a dialogue value, being a Dialogue Object.
     *@return dialogue Dialogue.
     */
    public Dialogue getDialogue() {
        return dialogue;
    }

    /**
     * gameOver method.
     * a method to display the GO interface if the stress is equals to 10 or stamina equals to 0.
     */
    public void gameOver() {
        if ((thePlayer.getStressStat() == 10) || (thePlayer.getStaStat() == 0)) {
            new InterfaceGameOver();
        }
    }

    /**
     * setAllanThere method. allows set the boolean allanThere with a new value
     * @param allanThere a boolean
     */
    public void setAllanThere(boolean allanThere) {
        this.allanThere = allanThere;
    }

    /**
     * setLucThere method. allows set the boolean lucThere with a new value
     * @param lucThere
     */
    public void setLucThere(boolean lucThere) {
        this.lucThere = lucThere;
    }

    /**
     * isPillowThere method. allows to return a boolean pillowThere
     * @return pillowThere a boolean
     */
    public boolean isPillowThere() {
        return pillowThere;
    }

    /**
     * setPillowThere method. allows set the boolean pillowThere with a new value
     * @param pillowThere a boolean
     */
    public void setPillowThere(boolean pillowThere) {
        this.pillowThere = pillowThere;
    }

    /**
     * isPenguinThere method. allows to return a boolean penguinThere
     * @return penguinThere a boolean
     */
    public boolean isPenguinThere() {
        return penguinThere;
    }

    /**
     * setPenguinThere method. allows set the boolean penguinThere with a new value
     * @param penguinThere a boolean
     */
    public void setPenguinThere(boolean penguinThere) {
        this.penguinThere = penguinThere;
    }

    /**
     * getInstructions method. return a String ArrayList named instructions
     * @return instructions, an arrayList of Strings.
     */
    public ArrayList<String> getInstructions() {
        return instructions;
    }

}
