/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */



public class Hand {

   private Card[] hand;   // The cards in the hand.
   private int count; 
   
   /**
    * Create a hand that is initially empty.
    */
   public Hand() {
      hand = new Card[5];
	  count = 0;
   }
   
   /**
    * Remove all cards from the hand, leaving it empty.
    */
   public void clear() {
      for(int i=0 ; i<hand.length; i++){ hand[i] = null; }
	  count = 0;
   }
   
   /**
    * Add a card to the hand.  It is added at the end of the current hand.
    * @param c the non-null card to be added.
    * @throws NullPointerException if the parameter c is null.
    */
   public void addCard(Card c) {
      
	  for(int i=0 ; i<hand.length; i++){ 
		if (hand[i] == null){
			hand[i] = c;
			count = count + 1;
			break;
		}
	 }

	  
   }
   
   /**
    * Remove a card from the hand, if present.
    * @param c the card to be removed.  If c is null or if the card is not in 
    * the hand, then nothing is done.
    */
   public void removeCard(Card c) {

  for(int i=0 ; i<hand.length; i++){ 
    if (hand[i]!=null && hand[i].equals(c)){
      hand[i] = null;
      count = count-1;
    }
  }

   }
   
   /**
    * Remove the card in a specified position from the hand.
    * @param position the position of the card that is to be removed, where
    * positions are starting from zero.
    * @throws IllegalArgumentException if the position does not exist in
    * the hand, that is if the position is less than 0 or greater than
    * or equal to the number of cards in the hand.
    */
   public void removeCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
      hand[position] = null;
      count --;
   }

   /**
    * Returns the number of cards in the hand.
    */
   public int getCardCount() {
      return count;
   }
   
   public Card[] getHandArr() {
	   return hand;
   }
   
   /**
    * Gets the card in a specified position in the hand.  (Note that this card
    * is not removed from the hand!)
    * @param position the position of the card that is to be returned
    * @throws IllegalArgumentException if position does not exist in the hand
    */
   public Card getCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
       return hand[position];
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same suit are
    * grouped together, and within a suit the cards are sorted by value.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortBySuit() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;
	  
      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
		 
         for (int i = nonnull+1; i < hand.length; i++) {
            Card c1 = hand[i];
			if (c1 != null){
				if ( c1.getSuit() < c.getSuit() ||
						(c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same value are
    * grouped together.  Cards with the same value are sorted by suit.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortByValue() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;
	  
      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
		 
         for (int i = nonnull+1; i < hand.length; i++) {
            
			Card c1 = hand[i];
            if (c1 != null){
				if ( c1.getValue() < c.getValue() ||
						(c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }
   
   public void printHand(){
	   
	   for(int i=0; i<hand.length; i++){
		   if (hand[i] != null){
			   System.out.println(hand[i]);
		   }
	   }
	   System.out.println();
   }
   
   /********** helper functions *****************/
   
   private void addCardTemp(Card c, Card[] h) {
	      
		  for(int i=0 ; i<h.length; i++){ 
			if (h[i] == null){
				h[i] = c;
				break;
			}
		 }

		  
	}
   
   private boolean containsCard(Card[] hand, Card c) {
	   for (int i = 0; i<hand.length; i++) {
		   if(hand[i]!=null && hand[i].equals(c)) {
			   return true;
		   }
	   }
	   return false;
   }
   
   //used for Card[]
   private boolean containsCardWithValue(Card[] hand, int c) {
	   for (int i = 0; i<hand.length; i++) {
		   if(hand[i]!=null && hand[i].getValue()==c) {
			   return true;
		   }
	   }
	   return false;
   }
   
   //used for Hand
   private boolean containsCardWithValue(int c) {
	   for (int i = 0; i<hand.length; i++) {
		   if(hand[i]!=null && hand[i].getValue()==c) {
			   return true;
		   }
	   }
	   return false;
   }
   
   //index of card in Card[]
   private int indexOfCard(Card[] cards, Card c) {
	   for(int i = 0; i<cards.length; i++) {
		   if(cards[i]!=null) {
			   if(cards[i].getValue()==c.getValue()) {
				   return i;
			   }
		   }
	   }
	   return -1;
   }
   
   private int higherFlush(Hand h) {
	  
	   //return -1 if this hands flush is lower than the flush being compared to
	   //return 1 if this hands flush is higher than the flush being compared to
	   //return 0 is its a tie, meaning the flushs are both the same
	  
	  sortByValue();
	  h.sortByValue();
	  Card[] a = hand;
	  Card[] b = h.getHandArr();
	  
	  for(int i = a.length-1; i>=0; i--) {
		  if(b[i].getValue()>a[i].getValue()) {

			  return -1;
		  } else if (b[i].getValue()<a[i].getValue()) {

			  return 1;
		  } else if (i==0) {

			  return 0;
		  }
	  }
	  return 404;
   }
   
   //tie breaker used for one pair and two pair
   private int pairTieBreaker(Hand h) {
	   sortByValue();
	   h.sortByValue();
	   Card[] a  = new Card[5];
	   Card[] b = new Card[5];
	   
	   for (int i = 0; i<a.length; i++) {
		   if(hand[i].getValue()!=this.highestDuplicate().getValue()) {
			   addCardTemp(hand[i], a);
		   }
		   
		   if(h.getHandArr()[i].getValue()!=h.highestDuplicate().getValue()) {
			   addCardTemp(h.getHandArr()[i], b);
		   }
	   }
	   /*
	   for(int i= 0; i<a.length; i++) {
		   System.out.println(a[i] + "|" + b[i]);
	   }
	   */
	   for(int i = a.length-1;i>=0; i--) {
		   //check to see if non pair cards are aces
		   if(containsCardWithValue(a, 1) && containsCardWithValue(b, 1)) {
			   //System.out.println("Tie: same hand");
			   //return 0;
		   } else if(containsCardWithValue(a, 1)) {
			   System.out.println("Won: higher non pair card");
			   return 1;
		   } else if(containsCardWithValue(b, 1)) {
			   System.out.println("Lost: lower non pair card");
			   return -1;
		   }
		   //check rest of non pair cards
		   if(a[i]!=null) {
			   if(a[i].getValue()>b[i].getValue()) {
				   System.out.println("Won: higher non pair card");
				   return 1;
			   }
			   if(a[i].getValue()<b[i].getValue()) {
				   System.out.println("Lost: lower non pair card");
				   return -1;
			   }
		   }	   
	   }
	   
	   System.out.println("Tie: same hand");
	   return 0;

   }
   
   private int highCardFinder(Hand h) {
	   sortByValue();
	   h.sortByValue();
	   Card[] a  = new Card[5];
	   Card[] b = new Card[5];
	   
	   for (int i = 0; i<a.length; i++) {
			   addCardTemp(hand[i], a);
			   addCardTemp(h.getHandArr()[i], b);
	   }
	   
	   for(int i = a.length-1;i>=0; i--) {
		   //check for aces
		   if(containsCardWithValue(a, 1) && containsCardWithValue(b, 1)) {
			   //System.out.println("Tie: same hand");
			   //return 0;
		   } else if(containsCardWithValue(a, 1)) {
			   System.out.println("Won: high card");
			   return 1;
		   } else if(containsCardWithValue(b, 1)) {
			   System.out.println("Lost: low card");
			   return -1;
		   }
		   //check rest of non pair cards
		   if(a[i]!=null) {
			   if(a[i].getValue()>b[i].getValue()) {
				   System.out.println("Won: high card");
				   return 1;
			   }
			   if(a[i].getValue()<b[i].getValue()) {
				   System.out.println("Lost: low card");
				   return -1;
			   }
		   }	   
	   }
	   
	   return 404;
   }

   /******************************** Implement your methods here ****************************************/
   
   public int numPairs() {
	   sortByValue();
	   Card[] pair = new Card[5];
	   int count = 0;
	   int uniquePairs = 0;
	   for (int i = 0; i<hand.length-1; i++) {
	   		if(hand[i].getValue()==hand[i+1].getValue()) {
	   			if(containsCard(pair, hand[i])==false) {
	   				uniquePairs++;
	   				count +=2;
	   			} else {
	   				count++;
	   			}
	   			addCardTemp(hand[i], pair);
	   		}
	   		
	   }
	   
	   if(uniquePairs==1 && count==3) {
		   //System.out.println("three of a kind");
		   return 1;
	   } else if (uniquePairs==1 && count==4) {
		   //System.out.println("four of a kind");
		   return 2;
	   } else if(uniquePairs==2 && count==5) {
		   //System.out.println("Full House");
		   return 2;
	   } else {
		   //System.out.println("number of pairs: " + uniquePairs);
		   return uniquePairs;
	   }
   }
   
   public boolean hasTriplet() {
	   sortByValue();
	   Card[] cards = new Card[5];
	   int[] counts = {0, 0, 0, 0, 0};
	   int count = 0;
	   int uniquePairs = 0;
	   
	   for(int i = 0; i<hand.length; i++) {
		   if(!containsCardWithValue(cards, hand[i].getValue())) {
			   counts[uniquePairs]++;
			   addCardTemp(hand[i], cards); 
			   uniquePairs++;
			   
		   } else {
			   counts[indexOfCard(cards, hand[i])]++;
		   }
	   }
	   
	   for(int i = 0;i<cards.length; i++) {
		   if(counts[i]==3) {
			   return true;
		   }
	   }
	   return false;
   }
   
   public boolean hasFlush() {
	   sortBySuit();
	   for (int i= 0; i<hand.length-1;i++ ) {
		   if(hand[i].getSuit()!=hand[i+1].getSuit()) return false;
	   }
	   return true;
   }
   
   public boolean hasStraight() {
	   sortByValue();
	   if(containsCardWithValue(hand, 1) && containsCardWithValue(hand, 10)&&containsCardWithValue(hand, 11) &&containsCardWithValue(hand, 12)&&containsCardWithValue(hand, 13)) {
		   return true;
	   }
	   for (int i = 0; i<hand.length-1; i++) {
	   		if(hand[i].getValue() + 1 != hand[i+1].getValue()) {
	   			return false;
	   		}
	   }
	   return true;
   }
   
   public boolean hasFullHouse() {
	   sortByValue();
	   Card[] cards = new Card[5];
	   int[] counts = {0, 0, 0, 0, 0};
	   int count = 0;
	   int uniquePairs = 0;
	   
	   for(int i = 0; i<hand.length; i++) {
		   if(!containsCardWithValue(cards, hand[i].getValue())) {
			   counts[uniquePairs]++;
			   addCardTemp(hand[i], cards); 
			   uniquePairs++;
			   
		   } else {
			   counts[indexOfCard(cards, hand[i])]++;
		   }
	   }
	   
	   boolean hasThreeOfAKind = false;
	   boolean hasTwoOfAKind = false;
	   for(int i = 0;i<cards.length; i++) {
		   if(counts[i]==3) {
			   hasThreeOfAKind=true;
		   }
		   if(counts[i]==2) {
			   hasTwoOfAKind = true;
		   }
	   }
	   
	   if(hasThreeOfAKind && hasTwoOfAKind) {
		   return true;
	   }
	   return false;
   }
   
   public boolean hasFourOfAKind() {
	   sortByValue();
	   Card[] cards = new Card[5];
	   int[] counts = {0, 0, 0, 0, 0};
	   int count = 0;
	   int uniquePairs = 0;
	   
	   for(int i = 0; i<hand.length; i++) {
		   if(!containsCardWithValue(cards, hand[i].getValue())) {
			   counts[uniquePairs]++;
			   addCardTemp(hand[i], cards); 
			   uniquePairs++;
			   
		   } else {
			   counts[indexOfCard(cards, hand[i])]++;
		   }
	   }
	   
	   for(int i = 0;i<cards.length; i++) {
		   if(counts[i]==4) {
			   return true;
		   }
	   }
	   return false;
   }
     
   public Card highestValue() {
	   Card highCard = hand[0];
	   for (int i = 0; i<hand.length; i++) {
		   if(hand[i].getValue()>highCard.getValue()) {
			   highCard = hand[i];
		   }
	   }
	   return highCard;
   }
   
   public Card highestDuplicate() {
	   
	   sortByValue();
	   boolean returnNull = true;
	   Card highCard = new Card(2, 0);
	   
	   Card[] duplicates = new Card[5];
	   for (int i = 0; i<hand.length-1; i++) {
		   if(hand[i].getValue()==hand[i+1].getValue()) {
			   returnNull = false;
			   duplicates[i] = hand[i];
		   }
		   //System.out.println(duplicates[i]);
	   }
	   
	   for(int i = 0; i<duplicates.length; i++) {
		   if(duplicates[i]!=null) {
			   if(duplicates[i].getValue()==1) {
				   return duplicates[i];
			   }
			   if(duplicates[i].getValue()>highCard.getValue()) {
				   highCard = duplicates[i];
			   }
			   
		   }
	   }
	   
	   if(!returnNull) {
		   return highCard;
	   } else {
		   return null;
	   }
	   
   }
   
   public boolean hasRoyalFlush() {
	   if(containsCardWithValue(10) && containsCardWithValue(11) && containsCardWithValue(12) && containsCardWithValue(13) && containsCardWithValue(1)) {
		   if (hasFlush()) {
			   return true;
		   }
	   }
	   return false;
   }
  
   
   public int compareTo(Hand h) {
	 //check royal flush
	   if(h.hasRoyalFlush() && this.hasRoyalFlush()) {
		   System.out.println("Tie: Royal flush");
		   return 0;  
	   } else if (!h.hasRoyalFlush() && this.hasRoyalFlush()) {
		   System.out.println("Won: Royal flush");
		   return 1;  
	   } else if (h.hasRoyalFlush() && !this.hasRoyalFlush()) {
		   System.out.println("Lost: Royal flush");
		   return -1;  
	   }
		   
	 //check straight flush
	   if((h.hasFlush() && h.hasStraight()) && (this.hasFlush() && this.hasStraight())) {
		   if(h.highestValue().getValue()>this.highestValue().getValue()) {
			   System.out.println("Lost: low Straight flush vs high Straight flush");
			   return -1;   
		   } else {
			   System.out.println("Won: high Straight flush vs low straight flush");
			   return 1;
		   }
	   } else if(!(h.hasFlush() && h.hasStraight()) && (this.hasFlush() && this.hasStraight())) {
		   System.out.println("Won: Straight flush");
		   return 1;
	   } else if((h.hasFlush() && h.hasStraight()) && !(this.hasFlush() && this.hasStraight())) {
		   System.out.println("Lost: Straight flush");
		   return -1;
	   }
	   
	   //check four of a kind
	   if(h.hasFourOfAKind() && this.hasFourOfAKind()) {
		     if(h.highestDuplicate().getValue()>this.highestDuplicate().getValue()) {
		    	 	System.out.println("Lost: low four of a kind vs high four of a kind");
		    	 	return -1;
		     } else {
		    	 	System.out.println("Won: high four of a kind vs low four of a kind");
		    	 	return 1;
		     }
	   } else if(!h.hasFourOfAKind() && this.hasFourOfAKind()) {
   	 	   System.out.println("Won: four of a kind");
		   return 1;
	   } else if(h.hasFourOfAKind() && !this.hasFourOfAKind()) {
		   System.out.println("Lost: four of a kind");
		   return -1;
	   }
	   
	   //check full house
	   if(h.hasFullHouse() && this.hasFullHouse()) {
		   if(h.highestDuplicate().getValue()>this.highestDuplicate().getValue()) {
			 System.out.println("Lost: low full house vs high full house");
		    	 return -1;
		   } else {
			 System.out.println("Won: high full house vs low full house");
		    	 return 1;
		   }
	   } else if(!h.hasFullHouse() && this.hasFullHouse()) {
		   System.out.println("Won: full house");
		   return 1;
	   } else if(h.hasFullHouse() && !this.hasFullHouse()) {
		   System.out.println("dsadas");
		   System.out.println("Lost: full house");
		   return -1;
	   }
	   
	   
	   //check flush
	   if(h.hasFlush() && this.hasFlush()) {
		   if(higherFlush(h)==-1) {
			   System.out.println("Lost: lower flush");
			   return -1;   
		   } else if (higherFlush(h)==1) {
			   System.out.println("Won: higher flush");
			   return 1;
		   } else if (higherFlush(h)==0) {
			   System.out.println("Tie: same flush");
			   return 0;
		   }
	   } else if (!h.hasFlush() && this.hasFlush()) {
		   System.out.println("Won: flush");
		   return 1;
	   } else if (h.hasFlush() && !this.hasFlush()) {
		   System.out.println("Lost: flush");
		   return -1;
	   }
	   
	   //check straight
	   if(h.hasStraight() && this.hasStraight()) {
		   if(h.highestValue().getValue()>this.highestValue().getValue()) {
			   System.out.println("Lost: low straight vs high straight");
			   return -1;
		   } else if (h.highestValue().getValue()<this.highestValue().getValue()) {
			   System.out.println("Won: high straight vs low straight");
			   return 1; 
		   } else {
			   System.out.println("Tie: same straight");
			   return 0;
		   } 
	   } else if (!h.hasStraight() && this.hasStraight()) {
		   System.out.println("Won: Straight");
		   return 1;
	   } else if (h.hasStraight() && !this.hasStraight()) {
		   System.out.println("Lost: Straight");
		   return -1;
	   }
	   
	   //check three of a kind
	   if(h.hasTriplet() && this.hasTriplet()) {
		   if (h.highestDuplicate().getValue()>this.highestDuplicate().getValue()) {
			   System.out.println("Lost: low three of a kind vs high three of a kind");
			   return -1;
		   } else if (h.highestDuplicate().getValue()<this.highestDuplicate().getValue()) {
			   System.out.println("Won: high three of a kind vs low three of a kind");
			   return 1;
		   } else {
			   System.out.println("both have same three of a kind? this shouldnt get called");
		   }
		   
	   } else if (!h.hasTriplet() && this.hasTriplet()) {
		   System.out.println("Won: Three of a kind");
		   return 1;
	   } else if (h.hasTriplet() && !this.hasTriplet()) {
		   System.out.println("Lost: Three of a kind");
		   return -1;
	   }
	   
	   //check two pair
	   if(h.numPairs()==2 && this.numPairs()==2) {
		   return pairTieBreaker(h);
	   } else if(h.numPairs()!=2 && this.numPairs()==2) {
		   System.out.println("Won: Two of a kind");
		   return 1;
	   } else if(h.numPairs()==2 && this.numPairs()!=2) {
		   System.out.println("Lost: Two of a kind");
		   return -1;
	   } 
	   
	   //check pair
	   if(h.numPairs()==1 && this.numPairs()==1) {
		   return pairTieBreaker(h);
	   } else if(h.numPairs()!=1 && this.numPairs()==1) {
		   System.out.println("Won: pair");
		   return 1;
	   } else if(h.numPairs()==1 && this.numPairs()!=1) {
		   System.out.println("Lost: pair");
		   return -1;
	   } 
	   
	   //check high card
	   return highCardFinder(h);


   }
   

}