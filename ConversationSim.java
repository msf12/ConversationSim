
public class ConversationSim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 = new Person("Jeff","0");
		System.out.println("p1: " + p1.getName() + ", Sociability: " + p1.getSociability() + ", Social Skill: " + p1.getSocialSkill() + "\n");
		Person p2 = new Person("Phil","1");
		System.out.println("p2: " + p2.getName() + ", Sociability: " + p2.getSociability() + ", Social Skill: " + p2.getSocialSkill() + "\n");
		int	response = p1.converse(p2.getID(), -1);
		System.out.println(p1.getName() + " began a conversation with " + p2.getName() + responseType(response) + "\n");
		boolean p1talking = true, p2talking = true;
		while (p1talking || p2talking) {
			response = p2.converse(p1.getID(),response);
			System.out.println(p2.getName() + " responded to " + p1.getName() + responseType(response) + "\n");
			if (response == 0)
				p2talking = false;
			else
				p2talking = true;
			if (!(p1talking || p2talking))
				break;
			response = p1.converse(p1.getID(),response);
			System.out.println(p1.getName() + " responded to " + p2.getName() + responseType(response) + "\n");
			if (response == 0)
				p1talking = false;
			else
				p1talking = true;
		}
	}
	
	public static String responseType(int r) {
		if (r == 0)
			return " by attempting to end the conversation";
		else if (r == 1)
			return " rudely";
		else if (r == 2)
			return " pleasantly";
		else
			return "error";
	}

}
