import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * ID: B0244247
 * Name: ���{��
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N(deck of cards):"); // ��J�n�X�ƵP
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on
		// your screen
		deck.printDeck(); // ��ƵPprint�X��, 1�ƵP�h52��

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/*
	 * This method is used for checking your result, not a part of your HW2
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank, checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/*
 * Description: �����O�Q�ΤT�h�j��N�@�i�i��J�P�[��cards�o�|��J�P�̭��A
 * for (int d = 1; d <= nDeck; d++) nDeck�N��ϥΪ̤@�}�l��J�nprint�X�X�|����J�P
 * for (int s = 1; s <= 4; s++) s�N��Card���O�̪�suit
 * for (int r = 1; r <= 13; r++) r�N��Card���O�̪�rank
 * Card card = new Card(s, r); new�@�ӥs��card��Card����,�ñNs��r��ӰѼƥN�JCard���O��
 * card.getSuit();  ���oSuit��
 * card.getRank();  ���oRank��
 * cards.add(card); cards�[�J�@�i��J�P
 *
 *for (Card card : cards) {   �Q��foreach�j��I�sprintCard() �̧ǦL�X�@�i�i��J�P
	 card.printCard();
	}
 */

class Deck {
	private ArrayList<Card> cards;

	// TODO: Please implement the constructor
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end

		for (int d = 1; d <= nDeck; d++) {

			for (int s = 1; s <= 4; s++) {

				for (int r = 1; r <= 13; r++) {
					
					Card card = new Card(s, r);
					card.getSuit();
					card.getRank();
					cards.add(card);
				}
			}
		}
	}

	// TODO: Please implement the method to print all cards on screen
	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		// please implement and reuse printCard method in Card class

		for (Card card : cards) {
			card.printCard();
		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/*
 * �Q��getSuit()�MgetRank()���o�@�i��J�P�����M�Ʀr�A�çQ��printCard()�L�X��J�P�����μƦr
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3,
						// Spades=4
	private int rank; // 1~13

	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method
	public void printCard() {
		// Hint: print (System.out.println) card as suit,rank, for example:
		// print 1,1 as Clubs Ace
		
		System.out.println(suit + "," + rank);
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}