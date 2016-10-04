import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * ID: B0244247
 * Name: 江宛諭
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N(deck of cards):"); // 輸入要幾副牌
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on
		// your screen
		deck.printDeck(); // 整副牌print出來, 1副牌則52行

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
 * Description: 此類別利用三層迴圈將一張張樸克牌加到cards這疊樸克牌裡面，
 * for (int d = 1; d <= nDeck; d++) nDeck代表使用者一開始輸入要print出幾疊的樸克牌
 * for (int s = 1; s <= 4; s++) s代表Card類別裡的suit
 * for (int r = 1; r <= 13; r++) r代表Card類別裡的rank
 * Card card = new Card(s, r); new一個叫做card的Card物件,並將s及r兩個參數代入Card類別裡
 * card.getSuit();  取得Suit值
 * card.getRank();  取得Rank值
 * cards.add(card); cards加入一張樸克牌
 *
 *for (Card card : cards) {   利用foreach迴圈呼叫printCard() 依序印出一張張樸克牌
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
 * 利用getSuit()和getRank()取得一張樸克牌的花色和數字，並利用printCard()印出樸克牌的花色及數字
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