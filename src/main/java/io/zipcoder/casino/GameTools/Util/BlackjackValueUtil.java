package io.zipcoder.casino.GameTools.Util;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.GameTools.Deck.Deck;

public class BlackjackValueUtil {
    public static int rankParse(Rank rank){
        switch (rank){
            case ACE:
                return 11;
            case JACK:
                return 10;
            case QUEEN:
                return 10;
            case KING:
                return 10;

                default:
                    return rank.getRankValue();
        }
    }
}
