import java.util.ArrayList;
import java.util.List;


public class Person {

	private final String Name, ID;
	private List<String> People;
	private final int Sociability, //lower is more social
					  SocialSkill; //lower is more socially apt
	private int DesireToConverse;
	private boolean endConversation;
	
	public Person(String name, String id) {
		Name = name;
		ID = id;
		People = new ArrayList<String>();
		Sociability = (int) (Math.random()*10+1);
		SocialSkill = (int) (Math.random()*10+1);
		DesireToConverse = 100;
		endConversation = false;
	}
	
	public Person(String name, String id, List<String> people) {
		this(name,id);
		People = (ArrayList<String>) people;
	}
	
	//-1 = conversation yet to begin, 0 = endConversation, 1 = continued unagreeably, 2 = continued agreeably
	public int converse(String partnerID, int partnerDialogueCode) {
		//personality variable calculations
		boolean friends = People.contains(partnerID);
		
		int dialogueModifier;
		if (partnerDialogueCode == 1)
			dialogueModifier = -10;
		else if (partnerDialogueCode == 2)
			dialogueModifier = 10;
		else if (partnerDialogueCode == 0)
			dialogueModifier = -20;
		else
			dialogueModifier = 0;
		
		endConversation = DesireToConverse < ((int) (Math.random()*100)) - (friends ? 10 : -5) - dialogueModifier + (endConversation ? 20 : 0);
		DesireToConverse -= Sociability + 1 - (((friends ? (int) (Math.random()*5) : 0)) + (dialogueModifier/10));
		
		return endConversation ? 0 : (((int) (Math.random()*10+1) > SocialSkill) ? 2 : 1);
	}

	public List<String> getPeople() {
		return People;
	}

	public void setPeople(List<String> people) {
		People = people;
	}
	
	public void addPerson(String personID) {
		People.add(personID);
	}

	public String getName() {
		return Name;
	}

	public String getID() {
		return ID;
	}
	
	public int getSociability() {
		return Sociability;
	}

	public int getSocialSkill() {
		return SocialSkill;
	}
	
}
