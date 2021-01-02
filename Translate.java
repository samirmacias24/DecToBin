package game;
import java.util.LinkedList;
import java.util.Scanner;

public class Translate {
	private	String decimalVal;
	private	String binaryVal;
	
	Translate()
	{
		decimalVal = "";
		binaryVal = "";
	}
	Translate(String val)
	{
		decimalVal = val;
	//	findBinary();
	}
	
	public void setDecimal(String dec)
	{
		decimalVal = dec;
	}
	final public String getDecimal()
	{
		return decimalVal;
	}
	
	public void setBinary(String num)
	{
		int value = 0;
		
		try {
			value = Integer.parseInt(num);
		}
		catch(Exception e)
		{
			binaryVal = "ERROR";
			decimalVal= "ERROR";
			e.getStackTrace();
			return;
		}
		
		setDecimal(num); // set decimal value
		
		//(Positive) value entered
		if(value >= 0 ) {
			LinkedList<Integer> list = new LinkedList<Integer>();

			// find binary value, place into LList
			while(value > 0) {	
				int val = value % 2 ;
				list.add(val);
				value = value / 2;
			}
		// sets the value(binaryVal)
			String obj = new String();
			obj = "";
			for(int j = list.size() - 1 ; j >= 0; j--)
			{
				obj = obj + list.get(j);
			}
			binaryVal = obj;
		}
		
		//(Negative) value entered
		else
		{
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			value = value / -1; // make value positive
			// find binary value, place into LList
			while(value > 0) {	
				int val = value % 2 ;
				list.add(val);
				value = value / 2;
			}

			// 2's compliment (1->0, 0->1)
			for(int i = list.size() - 1; i >= 0 ; i--)
			{
				if(list.get(i) == 0)
				{
					list.remove(i);
					list.add(i, 1);
				}
				else
				{
					list.remove(i);
					list.add(i, 0);
				}
			}
			// adding 1 to the answer
			int size = list.size();
			for(int i = 0; i < size ; i++)
			{
				// if last value equals '0'
				if(list.get(i) == 0)
				{
					list.remove(i);
					list.add(i, 1);
					break;
				}
				if(list.get(i) == 1)
				{
					list.remove(i);
					list.add(i, 0);
				}
				//if last element is 1 (we add another element)
				if(list.get(i) == 1 && i == size - 1)
				{
					list.remove(i);
					list.add(i, 0);
					list.add(1);
				}
			}
			// sets the answer to 16-bit(add any additional 1's needed)
			for(int i = list.size(); i < 16; i++)
			{
				list.add(1);
			}
			// sets the value(binaryVal)
				String obj = new String();
				obj = "";
				for(int j = list.size() - 1 ; j >= 0; j--)
				{
						obj = obj + list.get(j);
				}
				binaryVal = obj;
		}	
	}
	final public String getBinary()
	{
		return binaryVal;
	}	
}