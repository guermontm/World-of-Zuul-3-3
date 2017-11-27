import java.util.*;

/**
 * The class Sentences, having different list of sentences.
 * These sentences can be used by interacting with a non-player character (NPC).
 * They are used when the player talks with them, and this NPC has not important
 * sentence to say.
 * The sentences are short, and there is not possible to answer.
 * There are around 3-4 sentences that can be spoken by each NPC.
 * These sentences can be of different kinds: recall the quest to be done; to be a joke, ...
 * 
 * The 'sentences' class is composed by a constructor and two methods : randomsentence and randomNumber. 
 *
 *
 * @Nolan Lacroix 
 * @09/11/2017
 */
public class Sentences
{
    //simple sentences list for each no-player character.
    private ArrayList<String> listAxel;
    private ArrayList<String> listMartin;
    private ArrayList<String> listNolan;
    private ArrayList<String> listValentin;
    private ArrayList<String> listGuardian;
    private ArrayList<String> listThomas;
    private ArrayList<String> listMorgane;
    private ArrayList<String> listMarie;
    private ArrayList<String> listMrsGeniet;
    private ArrayList<String> listClement;
    
    //conversation sentence lists for NPC
    private ArrayList<String> listMainMrsGeniet;
    private ArrayList<String> listMainAxel;
    private ArrayList<String> listMainMartin;
    private ArrayList<String> listMainNolan;
    private ArrayList<String> listMainGuardian;
    private ArrayList<String> listMainPGTD;
    private ArrayList<String> listMainPGEnd;
    
    //conversation sentence lists for player
    private ArrayList<String> listMainPlayerToMrsGeniet;
    private ArrayList<String> listMainPlayerToAxel;
    private ArrayList<String> listMainPlayerToMartin;
    private ArrayList<String> listMainPlayerToNolan;
    private ArrayList<String> listMainPlayerToGuardian;
    private ArrayList<String> listMainPlayerToPGTD;
    private ArrayList<String> listMainPlayerToPGEnd;
    
    
    //Initialisation of simple sentences
    private String sentenceAxel1, sentenceAxel2, sentenceAxel3;
    private String sentenceValentin1, sentenceValentin2, sentenceValentin3;
    private String sentenceNolan1, sentenceNolan2, sentenceNolan3;
    private String sentenceMartin1, sentenceMartin2, sentenceMartin3;
    private String sentenceGuardian1, sentenceGuardian2, sentenceGuardian3;
    private String sentenceThomas1, sentenceThomas2;
    private String sentenceMorgane1, sentenceMorgane2;
    private String sentenceMarie1, sentenceMarie2;
    private String sentenceMrsGeniet1, sentenceMrsGeniet2;
    private String sentenceClement1, sentenceClement2;
    
    //Initialisation of conversation sentences for NPC
    private String sentenceMainMrsGeniet1, sentenceMainMrsGeniet2,sentenceMainMrsGeniet3,sentenceMainMrsGeniet4; //
    private String sentenceMainAxel1, sentenceMainAxel2, sentenceMainAxel3, sentenceMainAxel4, sentenceMainAxel5, sentenceMainAxel6; //6 Axel
    private String sentenceMainMartin1, sentenceMainMartin2, sentenceMainMartin3, sentenceMainMartin4, sentenceMainMartin5, sentenceMainMartin6,
    sentenceMainMartin7, sentenceMainMartin8; // 8
    private String sentenceMainNolan1, sentenceMainNolan2, sentenceMainNolan3, sentenceMainNolan4, sentenceMainNolan5, sentenceMainNolan6, 
    sentenceMainNolan7, sentenceMainNolan8; //8
    private String sentenceMainGuardian1, sentenceMainGuardian2, sentenceMainGuardian3, sentenceMainGuardian4, sentenceMainGuardian5, sentenceMainGuardian6; //6 
    private String sentenceMainPGTD1, sentenceMainPGTD2, sentenceMainPGTD3, sentenceMainPGTD4, sentenceMainPGTD5,
    sentenceMainPGTD6, sentenceMainPGTD7; //7
    private String sentenceMainPGEnd1, sentenceMainPGEnd2, sentenceMainPGEnd3, sentenceMainPGEnd4, sentenceMainPGEnd5, 
    sentenceMainPGEnd6, sentenceMainPGEnd7, sentenceMainPGEnd8, sentenceMainPGEnd9; //
    
    //Initialisation of conversation sentences for the Player
    private String sentenceMainPlayerToMrsGeniet1, sentenceMainPlayerToMrsGeniet2,
    sentenceMainPlayerToMrsGeniet3, sentenceMainPlayerToMrsGeniet4; //4 
    private String sentenceMainPlayerToAxel1, sentenceMainPlayerToAxel2, sentenceMainPlayerToAxel3,
    sentenceMainPlayerToAxel4, sentenceMainPlayerToAxel5, sentenceMainPlayerToAxel6; //6 to Axel
    private String sentenceMainPlayerToMartin1, sentenceMainPlayerToMartin2, 
    sentenceMainPlayerToMartin3, sentenceMainPlayerToMartin4, sentenceMainPlayerToMartin5,
    sentenceMainPlayerToMartin6,sentenceMainPlayerToMartin7; //7
    private String sentenceMainPlayerToNolan1, sentenceMainPlayerToNolan2, sentenceMainPlayerToNolan3,
    sentenceMainPlayerToNolan4, sentenceMainPlayerToNolan5, sentenceMainPlayerToNolan6, 
    sentenceMainPlayerToNolan7, sentenceMainPlayerToNolan8, sentenceMainPlayerToNolan9, sentenceMainPlayerToNolan10; //10
    private String sentenceMainPlayerToGuardian1, sentenceMainPlayerToGuardian2, 
    sentenceMainPlayerToGuardian3, sentenceMainPlayerToGuardian4, sentenceMainPlayerToGuardian5, sentenceMainPlayerToGuardian6; //
    private String sentenceMainPlayerToPGTD1, sentenceMainPlayerToPGTD2, sentenceMainPlayerToPGTD3, 
    sentenceMainPlayerToPGTD4, sentenceMainPlayerToPGTD5, sentenceMainPlayerToPGTD6; //6 to PG
    private String sentenceMainPlayerToPGEnd1, sentenceMainPlayerToPGEnd2, sentenceMainPlayerToPGEnd3, 
    sentenceMainPlayerToPGEnd4, sentenceMainPlayerToPGEnd5, sentenceMainPlayerToPGEnd6,
    sentenceMainPlayerToPGEnd7, sentenceMainPlayerToPGEnd8, sentenceMainPlayerToPGEnd9;//
    
    /**
     * Constructor for objects of class sentences
     * Contains all the phrase lists for each NPC.
     */
    public Sentences()
    {
       listAxel = new ArrayList<String>(); // This list can be called after talking with Axel. He is present into the hall, during all the game.
       listMartin = new ArrayList<String>(); //This list can be called when the quest "let's code" is "currently running". He is present into the TP1 room.
       listNolan = new ArrayList<String>(); //This list can be called when the quest "let's code" is "currently running". He is preent into the TP1 room with Martin.
       listValentin = new ArrayList<String>(); // [useless NPC] Situated into the TP1 room.
       listGuardian = new ArrayList<String>(); //The Guardian is situated into the elevator, and this list is called when the quest with him is finished.
       listThomas = new ArrayList<String>(); // [useless NPC] Situated in the resting room.
       listMorgane = new ArrayList<String>(); // [useless NPC] Situated in the stairs 
       listMarie = new ArrayList<String>(); // [useless NPC] Situated in the amphitheatre
       listClement = new ArrayList<String>(); // [useless NPC] Situated in the classroom
       listMrsGeniet = new ArrayList<String>(); //This list is called when the quest Martin's diploma is not "currently running".
       
       //initialization of NPC conversation lists
       listMainMrsGeniet = new ArrayList<String>(); // This list can be called when the quest "Martin's Diploma, the sequel" is "currently running"
       listMainAxel = new ArrayList<String>(); // This list is called when the player begin the game. 
       listMainMartin = new ArrayList<String>(); // This list is called when the quest "Martin's Diploma" is "currently running"
       listMainNolan = new ArrayList<String>(); // This list is called when the quest "Locked up" is starting.
       listMainGuardian = new ArrayList<String>(); // This list is called when the quest "Locked up" is "currently running"
       listMainPGTD = new ArrayList<String>(); // This list is called when the quest "Finding the COOPOO subject" is "currently runing"
       listMainPGEnd = new ArrayList<String>(); // This list is called when the quest "Trying to finish the day" is "currently running" and the player open the PG's desk.
       
       //initialization of Player conversation lists
       listMainPlayerToMrsGeniet = new ArrayList<String>(); // This list can be called when the quest "Martin's Diploma, the sequel" is "currently running"
       listMainPlayerToAxel = new ArrayList<String>(); // This list is called when the player begin the game. 
       listMainPlayerToMartin = new ArrayList<String>(); // This list is called when the quest "Martin's Diploma" is "currently running"
       listMainPlayerToNolan = new ArrayList<String>(); // This list is called when the quest "Locked up" is starting.
       listMainPlayerToGuardian = new ArrayList<String>(); // This list is called when the quest "Locked up" is "currently running"
       listMainPlayerToPGTD = new ArrayList<String>(); // This list is called when the quest "Finding the COOPOO subject" is "currently runing"
       listMainPlayerToPGEnd = new ArrayList<String>(); // This list is called when the quest "Trying to finish the day" is "currently running" and the player open the PG
             
       //The simple sentences
       sentenceAxel1="[Axel] *is tired*"; //joke
       sentenceAxel2="[Axel] I'm still waiting for my group. What are they doing?"; 
       sentenceAxel3="[Axel] If you get tired, you can buy food here."; //trick
       
       sentenceMartin1="[Martin] Hurry up ! We have to code, what are you waiting for?";
       sentenceMartin2="[Martin] Thanks for my L3 diploma ;)";
       sentenceMartin3="[Martin] Je vois pas pourquoi je parlerais anglais dans ton jeu, je suis un PNJ libre";
       
       sentenceNolan1="[Nolan] I have the toilet phobia now..";
       sentenceNolan2="[Nolan] I am hungry";
       sentenceNolan3="[Nolan] Let's go to work, I want to go home";
       
       sentenceValentin1="[Valentin] I am loner, my life is over. The topic of COOPOO stares at me, I want to become nobody";
       sentenceValentin2="[Valentin] *leans out of the window* I want to finish it, My COOPOO mates are not here";
       
       sentenceGuardian1="[The Guardian] I am your father";
       sentenceGuardian2="[The Guardian] When you do not have the strength, you must have the ruse, the weapon of intelligence.";
       sentenceGuardian3="[The Guardian] It's been 20 years that I keep nights and days this elevator.";
       
       sentenceThomas1="[Thomas] Alright";
       sentenceThomas2="[Thomas] psss psss pssssss *does not speak loudly, it seems not possible to hear him*";
       
       sentenceMorgane1="[Morgane] *Burp*";
       sentenceMorgane2="[Morgane] It's not because you are in a game that you have to speak to everybody, bitc*";
       
       sentenceMarie1="[Marie] Come with us to the escape game tonight !";
       sentenceMarie2="[Marie] Don't forget there are 9 other projects to finish after the COOPOO subject !";
       
       sentenceMrsGeniet1="[Mrs Geniet] chut";
       sentenceMrsGeniet2="[Mrs Geniet] I am listening to the students";
       
       sentenceClement1="[Clement] ";
       sentenceClement2="[Clement] ";
       
       //add the simple sentences to the list
       listAxel.add(sentenceAxel1);
       listAxel.add(sentenceAxel2);
       listAxel.add(sentenceAxel3);
       
       listMartin.add(sentenceMartin1);
       listMartin.add(sentenceMartin2);
       listMartin.add(sentenceMartin3);
       
       listNolan.add(sentenceNolan1);
       listNolan.add(sentenceNolan2);
       listNolan.add(sentenceNolan3);
       
       listValentin.add(sentenceValentin1);
       listValentin.add(sentenceValentin2);
       
       listGuardian.add(sentenceGuardian1);
       listGuardian.add(sentenceGuardian2);
       listGuardian.add(sentenceGuardian3);
       
       listMorgane.add(sentenceMorgane1);
       listMorgane.add(sentenceMorgane2);
       
       listMarie.add(sentenceMarie1);
       listMarie.add(sentenceMarie2);
       
       listMrsGeniet.add(sentenceMrsGeniet1);
       listMrsGeniet.add(sentenceMrsGeniet2);
       
       listClement.add(sentenceClement1);
       listClement.add(sentenceClement2);
       
       
       
       //The conversation sentences for NPC
       sentenceMainMrsGeniet1="[Mrs Geniet] Yes? What do you want from me?";
       sentenceMainMrsGeniet2="[Mrs Geniet] Hum.. okey.. take the keys of my office. ";
       sentenceMainMrsGeniet3="[Mrs Geniet] But do not forget to bring them back, and close the door.";
       sentenceMainMrsGeniet4="[Mrs Geniet] Are you kinding me ?! You do it on purpose ?! you are fired from GPhy.";
       
       sentenceMainAxel1="[Axel] Ah ! You are finally here ! Have you already done your COOPOO exercise?";
       sentenceMainAxel2="[Axel] Humm, you're going to have problems if you do not do it today";
       sentenceMainAxel3="[Axel] No, I'm waiting for my group to start working. They will arrive soon..";
       sentenceMainAxel4="[Axel] I advise you to get the subject from PG !";
       sentenceMainAxel5="[Axel] Yeah but I already have the subject ! If you want, go see PG in TD4.";
       sentenceMainAxel6="[Axel] He is in TD4, go ahead quickly !";
       
       sentenceMainMartin1="[Martin] Hey, how are you?";
       sentenceMainMartin2="[Martin] Yes, but I can't. I need my diploma..";
       sentenceMainMartin3="[Martin] Nothing. I need my diploma, but I'm lazy...";
       sentenceMainMartin4="[Martin] No, I am just lazy. I think Annie has my diploma, but she is doing the oral presentations.";
       sentenceMainMartin5="[Martin] I guess the diploma is inside the Annie's office. But actually, she's doing the oral presentations.";
       sentenceMainMartin6="[Martin] Nop, ahah ! Please, be friendly, help me. She is doing the oral presentations !";
       sentenceMainMartin7="[Martin] Thanks my friend !";
       sentenceMainMartin8="[Martin] Oh, yes, you're really nice ! Thanks !";
       
       sentenceMainNolan1="[Nolan] Hello? Help ! Someone there?";
       sentenceMainNolan2="[Nolan] I heard you, do not pretend not to hear me ! I'll tear your eyes off if you do not help me !";
       sentenceMainNolan3="*The person breaks the door with a supremely powerful force, jumps on you, catchs you, then plunges your head into the toilet. You died drowned.*";
       sentenceMainNolan4="[Nolan] Ahhh ! It's you? I recognized your voice. Please, help me ! It's been two hours since I am locked";
       sentenceMainNolan5="[Nolan] The lock is blocked, I have tried everything..";
       sentenceMainNolan6="[Nolan] No ! Don't do that. I'm going to look smart afterwards...";
       sentenceMainNolan7="[Nolan] Yes, well, get me out of here, solve quickly that ! Faster !";
       sentenceMainNolan8="[Nolan] Bweeerk, no ! Ahah, hurry up to help me please !";
       
       sentenceMainGuardian1="[The Guardian] Hello. I can feel that you need help.";
       sentenceMainGuardian2="[The Guardian] I am The Guardian and I seek the path of wisdom. I maintain the elevator. I live in it too. I meditate in it. ";
       sentenceMainGuardian3="[The Guardian] Only you can save him. I entrust you my legendary weapon. Take this crow-bar, take care of it.";
       sentenceMainGuardian4="[The Guardian] Nothing is weird, if it exists. I entrust you my legendary weapon, my crow-bar. Complete your destiny.";
       sentenceMainGuardian5="[The Guardian] A weapon is ineffective if you do not have the necessary strength. Go ahead.";
       sentenceMainGuardian6="[The Guardian] Take care. You have to be strong to use it.";
       
       sentenceMainPGTD1="[PG] Yes, hello?";
       sentenceMainPGTD2="[PG] It's time to start, right? It is to return for 18h, don't forget it...";
       sentenceMainPGTD3="[PG] Rude ! Start by saying hello !! "; // +1 stess
       sentenceMainPGTD4="[PG] No, but what is this behavior? Imagine yourself in a professional environment... You are not worthy of being a Gphy. Go away";//Game over
       sentenceMainPGTD5="[PG] Hum.. Ok, be careful next time...";
       sentenceMainPGTD6="[PG] Ah, because you're going to watch them and do nothing? Pff, go to work..."; // +1 stress
       sentenceMainPGTD7="[PG] Yes... Do not waste your time remaining. This is not very serious...";
       
       sentenceMainPGEnd1="[PG] ";
       sentenceMainPGEnd2="[PG] ";
       sentenceMainPGEnd3="[PG] ";
       sentenceMainPGEnd4="[PG] ";
       sentenceMainPGEnd5="[PG] ";
       sentenceMainPGEnd6="[PG] ";
       sentenceMainPGEnd7="[PG] ";
       sentenceMainPGEnd8="[PG] ";
       sentenceMainPGEnd9="[PG] ";
       
       //add the conversation sentences for NPC to the list 
       listMainMrsGeniet.add(sentenceMainMrsGeniet1);
       listMainMrsGeniet.add(sentenceMainMrsGeniet2);
       listMainMrsGeniet.add(sentenceMainMrsGeniet3);
       listMainMrsGeniet.add(sentenceMainMrsGeniet4);
       
       listMainAxel.add(sentenceMainAxel1);
       listMainAxel.add(sentenceMainAxel2);
       listMainAxel.add(sentenceMainAxel3);
       listMainAxel.add(sentenceMainAxel4);
       listMainAxel.add(sentenceMainAxel5);
       listMainAxel.add(sentenceMainAxel6);
       
       listMainMartin.add(sentenceMainMartin1);
       listMainMartin.add(sentenceMainMartin2);
       listMainMartin.add(sentenceMainMartin3);
       listMainMartin.add(sentenceMainMartin4);
       listMainMartin.add(sentenceMainMartin5);
       listMainMartin.add(sentenceMainMartin6);
       listMainMartin.add(sentenceMainMartin7);
       listMainMartin.add(sentenceMainMartin8);

       listMainNolan.add(sentenceMainNolan1);
       listMainNolan.add(sentenceMainNolan2);
       listMainNolan.add(sentenceMainNolan3);
       listMainNolan.add(sentenceMainNolan4);
       listMainNolan.add(sentenceMainNolan5);
       listMainNolan.add(sentenceMainNolan6);
       listMainNolan.add(sentenceMainNolan7);
       listMainNolan.add(sentenceMainNolan8);
       
       listMainGuardian.add(sentenceMainGuardian1);
       listMainGuardian.add(sentenceMainGuardian2);
       listMainGuardian.add(sentenceMainGuardian3);
       listMainGuardian.add(sentenceMainGuardian4);
       listMainGuardian.add(sentenceMainGuardian5);
       listMainGuardian.add(sentenceMainGuardian6);

       listMainPGTD.add(sentenceMainPGTD1);
       listMainPGTD.add(sentenceMainPGTD2);
       listMainPGTD.add(sentenceMainPGTD3);
       listMainPGTD.add(sentenceMainPGTD4);
       listMainPGTD.add(sentenceMainPGTD5);
       listMainPGTD.add(sentenceMainPGTD6);
       listMainPGTD.add(sentenceMainPGTD7);

       
       listMainPGEnd.add(sentenceMainPGEnd1);
       listMainPGEnd.add(sentenceMainPGEnd2);
       listMainPGEnd.add(sentenceMainPGEnd3);
       listMainPGEnd.add(sentenceMainPGEnd4);
       listMainPGEnd.add(sentenceMainPGEnd5);
       listMainPGEnd.add(sentenceMainPGEnd6);
       listMainPGEnd.add(sentenceMainPGEnd7);
       listMainPGEnd.add(sentenceMainPGEnd8);
       listMainPGEnd.add(sentenceMainPGEnd9);
       
       //The conversation sentences for the player
       sentenceMainPlayerToMrsGeniet1="[You] *whisper* Hello, I would like the Martin diploma please. He asked me to go get it.";
       sentenceMainPlayerToMrsGeniet2="[You] ";
       sentenceMainPlayerToMrsGeniet3="[You] ";
       sentenceMainPlayerToMrsGeniet4="[You] ";
       
       sentenceMainPlayerToAxel1="[You] Ouh? What? A work? Are you joking?";
       sentenceMainPlayerToAxel2="[You] No, I did not even look at the subject.";
       sentenceMainPlayerToAxel3="[You] Stop stressing me ! Have you already started, at least?";
       sentenceMainPlayerToAxel4="[You] Sh*t, I must quickly find my group !";
       sentenceMainPlayerToAxel5="[You] Well, you're as much in the sh*t as I am";
       sentenceMainPlayerToAxel6="[You] And where is PG so?";
       
       sentenceMainPlayerToMartin1="[You] So-So, we have to begin the COOPOO subject. Are you available?";
       sentenceMainPlayerToMartin2="[You] Good, what are you doing?";
       sentenceMainPlayerToMartin3="[You] You lost it?";
       sentenceMainPlayerToMartin4="[You] Okey so. I can go to find it. But where is you diploma?";
       sentenceMainPlayerToMartin5="[You] I can go to find your diploma, but it is need free... Against a chocolate bread?";
       sentenceMainPlayerToMartin6="[You] So, okey, I'm going ! Stay here !";
       sentenceMainPlayerToMartin7="[You] Luckily I'm kind, a kiss in return? :3";
       
       sentenceMainPlayerToNolan1="[You] Yes, who is it?";
       sentenceMainPlayerToNolan2="[You] *Say nothing, and try to escape the toilets on tiptoe*";
       sentenceMainPlayerToNolan3="[You] I'm so sorry, man ! Forgive me please !";
       sentenceMainPlayerToNolan4="[You] *Make fun of a guy like him stuck in the toilet, laugh, and insult him*";
       sentenceMainPlayerToNolan5="[You] Why are you locked?";
       sentenceMainPlayerToNolan6="[You] A simple solution is to call someone. For example PG. Right?";
       sentenceMainPlayerToNolan7="[You] Ahah, you're not smart !";
       sentenceMainPlayerToNolan8="[You] Hum okey, I'll try to find a solution.";
       sentenceMainPlayerToNolan9="[You] Oh, not cool for you..";
       sentenceMainPlayerToNolan10="[You] Okey, I'll try to smash that door !";
       
       sentenceMainPlayerToGuardian1="[You] Who are you?";
       sentenceMainPlayerToGuardian2="[You] Yes... My friend is locked into the toilets and I need help to open it.";
       sentenceMainPlayerToGuardian3="[You] Okey, so can you help me? Hum, my friend is locked and I want him out.";
       sentenceMainPlayerToGuardian4="[You] Hum.. You're weird.";
       sentenceMainPlayerToGuardian5="[You] How to use it?";
       sentenceMainPlayerToGuardian6="[You] Thanks.";
       
       sentenceMainPlayerToPGTD1="[You] Hello, I would like to have the COOPOO subject, please.";
       sentenceMainPlayerToPGTD2="[You] Can I have the COOPOO subject? I have to do it quickly";
       sentenceMainPlayerToPGTD3="[You] Yes, but it is pressing !!!";
       sentenceMainPlayerToPGTD4="[You] Yes, I am sorry...";
       sentenceMainPlayerToPGTD5="[You] Of course, I'll get started right now.";
       sentenceMainPlayerToPGTD6="[You] It will be easy, my mates are intelligent !";
       
       sentenceMainPlayerToPGEnd1="[You] ";
       sentenceMainPlayerToPGEnd2="[You] ";
       sentenceMainPlayerToPGEnd3="[You] ";
       sentenceMainPlayerToPGEnd4="[You] ";
       sentenceMainPlayerToPGEnd5="[You] ";
       sentenceMainPlayerToPGEnd6="[You] ";
       sentenceMainPlayerToPGEnd7="[You] ";
       sentenceMainPlayerToPGEnd8="[You] ";
       sentenceMainPlayerToPGEnd9="[You] ";
       
       //add the player conversation sentences for to the list 
       listMainMrsGeniet.add(sentenceMainPlayerToMrsGeniet1);
       listMainMrsGeniet.add(sentenceMainPlayerToMrsGeniet2);
       listMainMrsGeniet.add(sentenceMainPlayerToMrsGeniet3);
       listMainMrsGeniet.add(sentenceMainPlayerToMrsGeniet4);
       
       listMainAxel.add(sentenceMainPlayerToAxel1);
       listMainAxel.add(sentenceMainPlayerToAxel2);
       listMainAxel.add(sentenceMainPlayerToAxel3);
       listMainAxel.add(sentenceMainPlayerToAxel4);
       listMainAxel.add(sentenceMainPlayerToAxel5);
       listMainAxel.add(sentenceMainPlayerToAxel6);
       
       listMainMartin.add(sentenceMainPlayerToMartin1);
       listMainMartin.add(sentenceMainPlayerToMartin2);
       listMainMartin.add(sentenceMainPlayerToMartin3);
       listMainMartin.add(sentenceMainPlayerToMartin4);
       listMainMartin.add(sentenceMainPlayerToMartin5);
       listMainMartin.add(sentenceMainPlayerToMartin6);
       listMainMartin.add(sentenceMainPlayerToMartin7);

       listMainNolan.add(sentenceMainPlayerToNolan1);
       listMainNolan.add(sentenceMainPlayerToNolan2);
       listMainNolan.add(sentenceMainPlayerToNolan3);
       listMainNolan.add(sentenceMainPlayerToNolan4);
       listMainNolan.add(sentenceMainPlayerToNolan5);
       listMainNolan.add(sentenceMainPlayerToNolan6);
       listMainNolan.add(sentenceMainPlayerToNolan7);
       listMainNolan.add(sentenceMainPlayerToNolan8);
       listMainNolan.add(sentenceMainPlayerToNolan9);
       listMainNolan.add(sentenceMainPlayerToNolan10);
       
       listMainGuardian.add(sentenceMainPlayerToGuardian1);
       listMainGuardian.add(sentenceMainPlayerToGuardian2);
       listMainGuardian.add(sentenceMainPlayerToGuardian3);
       listMainGuardian.add(sentenceMainPlayerToGuardian4);
       listMainGuardian.add(sentenceMainPlayerToGuardian5);
       listMainGuardian.add(sentenceMainPlayerToGuardian6);

       listMainPlayerToPGTD.add(sentenceMainPlayerToPGTD1);
       listMainPlayerToPGTD.add(sentenceMainPlayerToPGTD2);
       listMainPlayerToPGTD.add(sentenceMainPlayerToPGTD3);
       listMainPlayerToPGTD.add(sentenceMainPlayerToPGTD4);
       listMainPlayerToPGTD.add(sentenceMainPlayerToPGTD5);
       listMainPlayerToPGTD.add(sentenceMainPlayerToPGTD6);

       listMainPlayerToPGEnd.add(sentenceMainPlayerToPGEnd1);
       listMainPlayerToPGEnd.add(sentenceMainPlayerToPGEnd2);
       listMainPlayerToPGEnd.add(sentenceMainPlayerToPGEnd3);
       listMainPlayerToPGEnd.add(sentenceMainPlayerToPGEnd4);
       listMainPlayerToPGEnd.add(sentenceMainPlayerToPGEnd5);
       listMainPlayerToPGEnd.add(sentenceMainPlayerToPGEnd6);
       listMainPlayerToPGEnd.add(sentenceMainPlayerToPGEnd7);
       listMainPlayerToPGEnd.add(sentenceMainPlayerToPGEnd8);
       listMainPlayerToPGEnd.add(sentenceMainPlayerToPGEnd9);
       
    }

    /**
     * randomSentence method
     * Choose a random phrase from the list provided as a parameter, and return it
     * @param list, an arrayList, being a NPC's list of sentences.
     * @return a String, chosen randomly by the method called "randomNumber"
     */
    public String randomSentence(ArrayList list)
    {
        ArrayList<String> lista=list;
        String sentence="";
        int sizeArray = list.size();
        //System.out.println(sizeArray);
        int i = randomNumber(sizeArray);
        sentence=lista.get(i);
        return sentence;
        
    }
    
     /**
     * randomNumber method
     * Choose a number between 0 and the size of the list and return it. (As a list can consist of only 4 sentences maximum).
     * @return an integer, being the random number chosen.
     */
    public int randomNumber(int size)
    {
        int randomNumber=(int)(Math.random()*size);
        //randomNumber = -1; // For the test, a negatif number has been chosen, to fail the test. [value to change]
        return randomNumber;
        
    }
    
    
    
    //getList of random sentence list
    /**
     * Method getListAxel allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListAxel()
    {
        return listAxel; 
    }
    
    /**
     * Method getListMartin allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMartin()
    {
        return listMartin; 
    }
    
    /**
     * Method getListNolan allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListNolan()
    {
        return listNolan; 
    }
    
    /**
     * Method getListValentin allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListValentin()
    {
        return listValentin; 
    }
    
    /**
     * Method getListGuardian allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListGuardian()
    {
        return listGuardian; 
    }
    
    /**
     * Method getListThomas allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListThomas()
    {
        return listThomas; 
    }
    
    /**
     * Method getListMorgane allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMorgane()
    {
        return listMorgane; 
    }
    
    /**
     * Method getListMarie allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMarie()
    {
        return listMarie; 
    }
    
    /**
     * Method getListClement allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListClement()
    {
        return listClement; 
    }
    
    /**
     * Method getListMrsGeniet allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMrsGeniet()
    {
        return listMainMrsGeniet; 
    }
    
    
    //get list of NPC conversation sentence
    /**
     * Method getListMainAxel allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainAxel(int index)
    {
        int i = index;
        return listMainAxel.get(i); 
    }
    
    /**
     * Method getListMainMrsGeniet allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainMrsGeniet(int index)
    {
        int i = index;
        return listMainMrsGeniet.get(i); 
    }
    
    /**
     * Method getListMainNolan allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainNolan(int index)
    {
        int i = index;
        return listMainNolan.get(i); 
    }
    
    /**
     * Method getListMainMartin allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainMartin(int index)
    {
        int i = index;
        return listMainMartin.get(i); 
    }
    
    /**
     * Method getListMainGuardian allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainGuardian(int index)
    {
        int i = index;
        return listMainGuardian.get(i); 
    }
    
    /**
     * Method getListMainPG allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainPGTD(int index)
    {
        int i = index;
        return listMainPGTD.get(i); 
    }
    
    /**
     * Method getListMainPG allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainPGEnd(int index)
    {
        int i = index;
        return listMainPGEnd.get(i); 
    }
    
    //Get list of Player conversation sentence
    /**
     * Method getListMainPlayerToAxel allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainPlayerToAxel(int index)
    {
        int i = index;
        return listMainPlayerToAxel.get(i); 
    }
    
    /**
     * Method getListMainPlayerToMrsGeniet allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    
    
    public String getListMainPlayerToMrsGeniet(int index)
    {
        int i = index;
        return listMainPlayerToMrsGeniet.get(i); 
    }
    
    /**
     * Method getListMainPlayerToNolan allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainPlayerToNolan(int index)
    {
        int i = index;
        return listMainPlayerToNolan.get(i); 
    }
    
    /**
     * Method getListMainPlayerToMartin allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainPlayerToMartin(int index)
    {
        int i = index;
        return listMainPlayerToMartin.get(i); 
    }
    
    /**
     * Method getListMainPlayerToGuardian allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListMainPlayerToGuardian(int index)
    {
        int i = index;
        return listMainPlayerToGuardian.get(i); 
    }
    
    /**
     * Method getListMainPlayerToPG allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListPlayerToMainPGTD(int index)
    {
        int i = index;
        return listMainPlayerToPGTD.get(i); 
    }
    
    /**
     * Method getListMainPlayerToPG allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public String getListPlayerToMainPGEnd(int index)
    {
        int i = index;
        return listMainPlayerToPGEnd.get(i);
    }
}  