package invertedindex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import textLocation.TextLocation;

public class InvertedIndex {
	private final HashMap<String, Set<TextLocation>> invertedIndex;
	
	public InvertedIndex(){
		this.invertedIndex = new HashMap<String,Set<TextLocation>>();
	}
	//add word and the location of that word in file to the index
	
	public void add(String word, TextLocation textLocation){
		//remove periods, question marks etc.
		word = word.replaceAll("\\W", "");
		//if the index doesnot have word, add it. Otherwise update the set attached to the word.
		if(invertedIndex.containsKey(word)){
			Set<TextLocation> set = invertedIndex.get(word);
			set.add(textLocation);
			invertedIndex.put(word, set);
		}else{
			//since it's set there shoud never be any duplicate text location
			Set<TextLocation> set = new HashSet<TextLocation>();
			set.add(textLocation);
			invertedIndex.put(word, set);
		}
	}
	
	/*retrive set of text location that contain the given word.
	 * in word is not in inverted index, return null
	 * text location are not in sorted order*/
	public Set<TextLocation> get(String word){
		
		return invertedIndex.get(word);
		
	}
	
	
	//prints out every word followed by a group of its text location.
	@Override public String toString(){
		String printedString = "";
		Set<String> set = invertedIndex.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String word = it.next();
			Set<TextLocation> textLocations = invertedIndex.get(word);
			Iterator<TextLocation> it2 = textLocations.iterator();
			String locationText = "";
			while(it2.hasNext()){
				TextLocation textLocation = it2.next();
				if(it2.hasNext()){
					locationText += textLocation.toString()+ ", ";
				}else{
					locationText += textLocation.toString();
				}
			}
			printedString += String.format("\"%s\":    %s\n",word, locationText);
		}
		return printedString;
	}
	
	//clear the inverted index of all entries.
	public void clear(){
		invertedIndex.clear();
	}
	

}
