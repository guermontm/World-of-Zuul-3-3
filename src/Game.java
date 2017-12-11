
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The main class of the game. When a new game is chreated and play(int) is
 * called, the game is launched. The user appears in a room and the main quest
 * is activated. In the constructor we call every other constructors. This class
 * is where we call all the methods from the other classes in order for the game
 * to run.
 *
 * @author (Grp5)
 * @version (V4 - 23/11/17)
 */
public class Game
{

    // this attribute represents the current room in which the player is located.
    protected Room currentRoom;
    // this attribute represents the player 
    protected Player thePlayer;
    // the CommandLetter attribute which analyse the command of the user 
    private CommandLetter commandLetter;
    TestTimer timerPlayer;
    RandomEvent event;

    char character;

    // an integer that can be changed randomly between 1
    private int randomInt;
    private Dialogue dialogue;

    private HashMap<Room, String> minimap;

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

    //class quest
    private Quest quest;

    // Attic & basement have been added to check the up & down directions.
    Room annieOffice, classRoom, downstairsCorridor1, downstairsCorridor2, upstairsCorridor1, upstairsCorridor2, upStairs, downStairs, pgOffice, tp1, td1, td4, wc, hall, theatre, downstairsLift, upstairsLift, restRoom;

    /**
     * Constructor for objects of class Game it initialises the different
     * parameters for the game
     *
     * @param player
     */
    public Game(int player)
    {
        // the constructor will define which player the user has chosen
        switch (player)
        {
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

        event = new RandomEvent(thePlayer);

        commandLetter = new CommandLetter();

        //NPCs
        axel = new NPC("Axel", false);
        nolan = new NPC("Nolan", true);
        martin = new NPC("Martin", true);
        annie = new NPC("Mrs Geniet", true);
        guardian = new NPC("Guardian", true);
        M2 = new NPC("M2", true);
        valentin = new NPC("Valentin", true);
        thomas = new NPC("Thomas", true);
        morgane = new NPC("Morgane", true);
        marie = new NPC("Marie", true);
        clement = new NPC("Clément", true);
        PGTD = new NPC("PGTD", true);

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
        diploma = new SimpleObject("Martin's diploma", true);
        annieDesk.addObject(diploma);
        pgDesk = new SimpleObject("desk in PG's office", false);
        board = new SimpleObject("board", false);
        couch = new Container("couch", false);
        deskTp1 = new Container("desk", false);
        computer = new SimpleObject("computer", true);
        deskTp1.addObject(computer);
        wardrobe = new Container("wardrobe", false);
        tissue = new SimpleObject("tissue", true);
        wardrobe.addObject(tissue);

        quest = new Quest();
        dialogue = new Dialogue();
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand()
    {
        boolean wantToQuit = false;

        // char character;
        // character = commandLetter.readCommand();
        if (character == '!')
        {
            System.out.println("This letter is not valid.");
        } else if ((character == 'n') || (character == 'N'))
        {
            // go north
            changeRoom("north");
        } else if ((character == 'e') || (character == 'E'))
        {
            // go east
            changeRoom("east");
        } else if ((character == 's') || (character == 'S'))
        {
            // go south
            changeRoom("south");
        } else if ((character == 'w') || (character == 'W'))
        {
            // go west
            changeRoom("west");
        } else if ((character == 'i') || (character == 'I'))
        {
            interact();
        } else if ((character == 'h') || (character == 'H'))
        {
            printHelp();
        } else if ((character == 'q') || (character == 'Q'))
        {
            System.out.println("You entered Q/");
            // If the user types 'q', the quit() method asks if he really wants to quit.
            // If so, wantToQuit is set to 'true'.
            wantToQuit = quit();
        }

        return wantToQuit;
    }

    /**
     * Method getInformationPlayer print all the information and statistics
     * about the player
     *
     */
    public void getInformationPlayer()
    {
        System.out.println("Your stats:");
        System.out.println("You have "+thePlayer.getStrStat()+" strength");
        System.out.println("You have "+thePlayer.getStaStat()+" stamina");
        System.out.println("You have "+thePlayer.getIntStat()+" intelligence");
        System.out.println("You have "+thePlayer.getStressStat()+" stress");
        System.out.println("You have "+thePlayer.getSpeStat()+" speech");
        System.out.println("You have "+thePlayer.getMoney()+" money");
        if (!thePlayer.getCrowbar())
        {
            System.out.println("You aren't carrying anything special, except for your papers and stuff.");
        } else
        {
            System.out.println("You have your crowbar in your inventory. You love that thing.");
        }

    }

    private void createRooms()
    {

        // For the map display
        minimap = new HashMap<Room, String>();

        // create the rooms
        downstairsCorridor1 = new Room("Corridor", "A corridor in the b2 building.");
        downstairsCorridor2 = new Room("Corridor", "Another corridor.");
        upstairsCorridor1 = new Room("Corridor", "A corridor in the b2 building, at the first story.");
        upstairsCorridor2 = new Room("Corridor", "Another corridor, at the first story.");
        downstairsLift = new Room("Lift", "The lift (elevator). You are level 1 (downstairs)");
        upstairsLift = new Room("Lift", "The lift which connects the two levels. You are level 2 (upstairs).");
        annieOffice = new Room("Mrs. Geniet's Office", "The office of Mrs. Genient, the teacher of all GPhy students..");
        downStairs = new Room("Staircase", "The stairs that connect the two levels together. Climbing them can get exhausting.");
        classRoom = new Room("Classroom", "The classroom where the main courses are.");
        upStairs = new Room("Staircase", "You are at the top of the staircase.");
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
        td4.setExits(null, null, downstairsCorridor1, null);
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

        currentRoom = hall;  // The game starts witht he plater located in the hall.

    }

    /**
     *
     */
    public void addItems()
    {
        //items for the hall
        hall.addItem(axel);
        hall.addItem(cafet);
        //items for the theatre
        theatre.addItem(annie);
        theatre.addItem(marie);
        //items for the lift
        downstairsLift.addItem(guardian);
        upstairsLift.addItem(guardian);
        //items for annie's Office
        annieOffice.addItem(annieDesk);
        //items for PG's office
        pgOffice.addItem(pgDesk);
        //items for TD4
        td4.addItem(board);
        td4.addItem(PGTD);
        //items for TD1
        td1.addItem(M2);
        //items for wc
        wc.addItem(nolan);
        //items for restroom
        restRoom.addItem(couch);
        restRoom.addItem(thomas);
        //items for TP1
        tp1.addItem(martin);
        tp1.addItem(wardrobe);
        tp1.addItem(deskTp1);
        tp1.addItem(valentin);
        //items for the stairs
        downStairs.addItem(morgane);
        //items for the classroom
        classRoom.addItem(clement);
    }

    /**
     * allows the player to change room, depends on the exits that exists in the
     * current room. Depends on what character the player types : N, S, E, W
     * when the player enter in the new room, depending of the room, some random
     * event can appear
     *
     * @param direction The direction in which the player is trying to go.
     */
    public void changeRoom(String direction)
    {
        Room nextRoom = null;
        // Planning to go to the next room. (hashmap browsing) 
        nextRoom = currentRoom.getExits().get(direction);

        if (nextRoom == null)
        {
            System.out.println("You can't go this way.");
        } else
        {
            // Moving to the next room
            currentRoom = nextRoom;
            System.out.println("Current location : \t " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());

            // Displaying the available exits
            System.out.print("Exits: ");
            for (String key : currentRoom.getExits().keySet())
            {
                if (currentRoom.getExits().get(key) != null)
                {
                    System.out.print(key + "\n");
                }
            }
            System.out.println();

            if ((currentRoom == upstairsCorridor2) || (currentRoom == upstairsCorridor1) || (currentRoom == downstairsCorridor1) || (currentRoom == downstairsCorridor2))
            {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 20);
                rEvent(randomNum);
            }
        }
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play()
    {
        printWelcome();
        createRooms();
        addItems();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished)
        {
            // Command command = parser.getCommand();
            character = commandLetter.readCommand();
            // finished = processCommand(command)(;    
            System.out.println(" " + thePlayer.getStressStat());
            scenario();

            finished = processCommand();

            if ((thePlayer.getStressStat() == 10) || (thePlayer.getStaStat() == 0))
            {
                finished = true;
                System.out.println("You are not ready for this, we are sorry...");
            }
        }
        System.out.println("Thank you for playing. It was nice seeing you today. Goodbye. Hope you have a great day.");
    }

    /**
     * method that uses the randomInt attribute to call randomly a method in the
     * RandomEvent class (each number is linked to a method in RandomEvent)
     *
     * @param give a random integer that allow to know if a randomEvent will
     * appears
     */
    public void rEvent(int randomInt)
    {
        switch (randomInt)
        {
            case 2:
                event.hiddenCandy();
                break;
            case 3:
                event.allanJoke();
                break;
            case 4:
                event.pillowAttack();
                break;
            case 5:
                event.adaHelp();
                break;
            case 6:
                event.penguinHug();
                break;
            case 7:
                event.teacherMeeting();
                break;
            case 8:
                event.conversation();
                break;
        }
    }

    /**
     * Method explore allow knowing the item on a room
     *
     */
    public void explore()
    {
        currentRoom.printItems();
    }

    /**
     * Method interact allow interacting with the item of the room if it is
     * possible
     *
     */
    public void interact()
    {

        if (currentRoom.listRoomItem.size() != 0)
        {
            System.out.println("What item do you want to interact with ?");
            currentRoom.printItems();

            Scanner sc = new Scanner(System.in);

            int n = Integer.parseInt(sc.next());

            for (int i = 0; i < currentRoom.listRoomItem.size(); i++)
            {
                // Player wishes to interact with object of index i
                if (n == i)
                {
                    System.out.print("You are interacting with the item " + currentRoom.listRoomItem.get(i).itemName);
                    currentRoom.listRoomItem.get(i).interactItem();

                    if (currentRoom.listRoomItem.get(i).dialogue.getStressDialogue() != 0)
                    {

                        thePlayer.addStat("stressStat", currentRoom.listRoomItem.get(i).dialogue.getStressDialogue());
                    }

                    if (currentRoom.listRoomItem.get(i).dialogue.getKeyBool())
                    {
                        thePlayer.setKey(true);
                    }

                    switch (currentRoom.listRoomItem.get(i).getName())
                    {
                        case ("PGTD"):
                            PGTD.setLock(); //goes away
                            System.out.println("pg lock");
                            nolan.setLock(); //Conversation with Nolan in the toilet is available
                            martin.setLock(); //Conversation with Martin about the diploma is available
                            quest.endQuest(0); //this quest is ended and the next one is started
                            quest.startQuest(1);
                            System.out.println(" "+quest.getStatus(1));
                            quest.startQuest(2);
                            quest.startQuest(3);
                            break;
                        case ("Martin"):
                            annie.setLock(); //unlocks conversation with annie in the theatre
                            quest.endQuest(2);
                            quest.startQuest(4);
                        default:
                            break;
                    }

                }
            }
        } else
        {
            System.out.println("There is nothing to interact with in this room...");
        }

    }

    /**
     * Method scenario allow knowing the quest started and not finished Stub for
     * now
     */
    public void scenario()
    {

        if ((currentRoom == hall) && (axel.getLock() == false))
        {
            printHelp(); //to give instructions to the player at the beginning, mettre une touche a presser pour continuer

            //at the start of the game, a conversation with Axel begins automatically
            axel.interactItem();
            //at the end of the conversation, you have all the information you need, axel does not talk to you about that again
            axel.setLock();
            System.out.println("axel est lock");
            //the first quest is launched
            quest.startQuest(0);
            System.out.println("quest started");
            PGTD.setLock();
            System.out.println("PG unlock");
        }

        //next thing happens when you go into TD4 and talk to PG
        //while (quest.getStatus(0).equals("currently running"))
        //{
        //}
        //next quests are with Martin and Nolan
//        while (quest.getStatus(2).equals("currently running"))
//        { 
//            if (currentRoom == td1) //et qu'on interagit avec martin
//            {
//                martin.interactItem();
//                annie.setLock(); //unlocks conversation with annie in the theatre
//                quest.endQuest(2);
//                quest.startQuest(4);
//            }                       
//        }
//        
//        while (quest.getStatus(4).equals("currently running"))
//        {
//            if (currentRoom == theatre) //again, interaction
//            {
//                annie.interactItem(); //if you do it well you have the key to the office and then you need to go take the diploma
//                
//                
//            }
//        }
    }

    /**
     * Print out some help information. Contains all the information the user
     * needs to know about the game.
     */
    private void printHelp()
    {
        System.out.println("__________________HELP___________________");
        System.out.println("You are wandering in the B2 building.");
        System.out.println("Your goal is to deliver a project.");
        System.out.println("You can move, and interact with te world.");
        System.out.println("n: \t\tgo north");
        System.out.println("e: \t\tgo east");
        System.out.println("s: \t\tgo south");
        System.out.println("w: \t\tgo west");
        System.out.println("h: \t\thelp, duh");
        System.out.println("q: \t\tquit");
        System.out.println("spacebar: \tInteract");
        System.out.println("_________________________________________");
        getInformationPlayer();
        System.out.println("_________________________________________");
        System.out.println("You are in : " + currentRoom.getName());
        
        
    }

    /**
     * Print out some welcome text. Contains all the information the user needs
     * to know about the game.
     */
    private void printWelcome()
    {
        System.out.println("\n\n\n");
        System.out.println("<////////////////////////////////[]========0");
        System.out.println("\n");
        System.out.println("_________\\/\\/ O R L D 0 F Z U U L___________");
        System.out.println("\n");
        System.out.println("0========[]\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\>\n\n\n");
        System.out.println("Welcome to World of Zuul.");
        System.out.println("You have to deliver a COOPOO project");
        System.out.println("on time to the evil lord PG.");
        System.out.println("May the odds be with you.");
        System.out.println("_________________________________________");
        System.out.println("Press any key to enter the beautiful world of Zuul...");
    }

    /**
     * allows the player to quit the game
     */
    public boolean quit()
    {
        System.out.println("Are you sure? [Y/N]");
        char character;
        Scanner reader;
        reader = new Scanner(System.in);
        character = reader.next().charAt(0);
        if ((character != 'y') && (character != 'Y'))
        {
            System.out.println("Thought so.");
            return (false);
        } else
        {
            System.out.println("Hope you had a good time.");
            return (true);
        }

    }

    public Item getItem(String name)
    {
        int i;
        String n;
        for (i = 0; i < currentRoom.listRoomItem.size(); i++)
        {
            n = currentRoom.listRoomItem.get(i).getName();
            if (name.equals(n))
            {
                return currentRoom.listRoomItem.get(i);
            }
        }
        return martin;
    }

    public Player getPlayer()
    {
        return thePlayer;
    }

}
