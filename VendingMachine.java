import java.text.DecimalFormat;
/**
 * This class contains the VendingMachine class file that is called upon by another Main class.
 * To add an item to the vending machine, the user must call upon the addItem() method, inputs the name of the item and the price
 * are added to separate String[] and double[] arrays. 
 * 
 * The main method that this class uses is seperated between three index variables for each product
 * and switches between them using an index number variable to cycle between all three variables.
 * 
 * The inventory is also split up between two index variables.
 * 
 * @author  s26600042 (Zander Coffman)
 */
public class VendingMachine 
{
	//add change amount method
	DecimalFormat formatter = new DecimalFormat("#.00"); //decimal formatter for organizing how the integers in amount is aligned
	private int pennies; //amount of pennies
	private int quarters; //amount of quarters
	private int dimes; //amount of dimes
	private int nickels; //amount of nickels
	private double money; //total amount of money
	private int x = 0; //variable used to organize inventory
	
	private String[] itemsAvaliable_Name = {};
	private double[] itemsAvaliable_Price = {};
	private int[] itemsAvaliable_Amount = {};

	private String[] inventory_name = {};
	private int[] inventory_amount = {};

	//CONSTANTS
	private final double penny_amount = 0.01;
	private final double quarter_amount = 0.25;
	private final double dime_amount = 0.10;
	private final double nickel_amount = 0.05;
	
	//default constructor if there are no inputs when the method is called
	public VendingMachine() 
	{
		pennies = 0;
		quarters = 0;
		dimes = 0;
		nickels = 0;
	}
	//constructor if there are all inputs when the method is called
	public VendingMachine(int pennies, int nickels, int dimes, int quarters) 
	{
		this.pennies = pennies;
		this.quarters = quarters;
		this.dimes = dimes;
		this.nickels = nickels;
	}
	
	//private method that adds up of all of the coins and sets it to a variable 'money'
	private void addMoney()
	{
		money = (pennies * penny_amount) + (quarters * quarter_amount) + (nickels * nickel_amount) + (dimes * dime_amount);
	}

	//private method that gets the maximum letters for another method
	private int getHighestCharacters()
	{
		int highest = 0;
		//12
		for (int i = 0; i < itemsAvaliable_Name.length; i++)
		{
			if (itemsAvaliable_Name[i].length() > highest)
			{
				highest = itemsAvaliable_Name[i].length();
			}
		}
		while (highest <= 12)
		{
			highest++;
		}
		return highest;
	}
	
	public String addCans(int index, int input)
	{
		itemsAvaliable_Amount[index] += input;
		return "Successfully added " + input + " cans to " + itemsAvaliable_Name[index] + ".";
	}
	/**
	 * This is a method that adds a(n) item to the vending machine.
	 * Three variables called itemsAvaliable_Name, itemsAvaliable_Price, and itemsAvaliable_Amount
	 * are placed in three temporary holder variables with the index of the temporary variables 
	 * set to the length of the variable, but added to one, respectively. The updated item is set to the
	 * most recent length of the placeholder variable, and the original variables are then set to the placeholder
	 * variables, respectively.
	 * @param name The name of the product.
	 * @param price The price of the product.
	 * @param amount The amount the user is wanting to sell of the inputted product.
	 * @return "Successfully made " + amount + " " + name + "(s) with INDEX " + (updatedList.length - 1) + "."
	 */
	public String addItem(String name, double price, int amount)
	{
		//these variables hold the length of the current variable but adds a length of 1 to make a new addition to the future variable(s)
		String[] updatedList = new String[itemsAvaliable_Name.length + 1];
		double[] updatedPrice = new double[itemsAvaliable_Price.length + 1];
		int[] updatedAmount = new int[itemsAvaliable_Amount.length + 1];
		
		// copying the content from the original variable to a placeholder variable by using a for loop for the length & accompanies for both variables
		for (int i = 0; i < itemsAvaliable_Name.length; i++)
		{
			updatedList[i] = itemsAvaliable_Name[i];
			updatedPrice[i] = itemsAvaliable_Price[i];
			updatedAmount[i] = itemsAvaliable_Amount[i];
		}
	
		//the next lines add the parameters in the method to the variables' index
		updatedList[updatedList.length - 1] = name;
		updatedPrice[updatedPrice.length - 1] = price;
		updatedAmount[updatedAmount.length - 1] = amount;
		
		//the next lines declare the already initialized variables to the updated variables, updatedList and updatedPrice.
		itemsAvaliable_Name = updatedList;
		itemsAvaliable_Price = updatedPrice;
		itemsAvaliable_Amount = updatedAmount;

		return "Successfully made " + amount + " " + name + "(s) with INDEX " + (updatedList.length - 1) + ".";
	}

	/**
	 * This method first calls the addMoney() function which adds the value of current coins, and sets it to the variable money.
	 * It creates two new arrays: "updatedInventory" and "updatedAmount" that are one element larger than the variables "inventory_name" 
	 * and "inventory_amount"
     * It uses a for loop to copy the content of the current arrays into the placeholder arrays
	 * If the product amount checked minus the counter variable is greater than zero or if the product in stock is greater than zero
	 * then it will check if the money subtracted from the product of the counter and the price variable of the index
	 * then the item (counter times) will be added to the user's inventory and their money will be subtracted
	 * @param index
	 * @param counter
	 * @return "Product not in stock." | "You do not have enough money." | "Successfully bought " + counter + " " + itemsAvaliable_Name[index] + "(s)."
	 */
	public String buyItem(int index, int counter)
	{
		/*
		 * The exact same code from the addItem() method, but copied over here to serve one variable and had made some edits
		 */
		if (itemsAvaliable_Name.length < 0)
		{
			return "Error! Not enough items.";
		}
		//calls the addMoney() method in order to update the current value of the variable Money
		addMoney();
		//these variables hold the length of the current variable but adds a length of 1 to make a new addition to the future variable(s)
		String[] updatedInventory = new String[inventory_name.length + 1];
		int[] updatedAmount = new int[inventory_amount.length + 1];
		// copying the content from the original variable by using a for loop for the length & accompanies for both variables
		for (int i = 0; i < inventory_name.length; i++)
		{
			updatedInventory[i] = inventory_name[i];
			updatedAmount[i] = inventory_amount[i];
		}
	
		//if there is no more of the product left in stock, then the addition problem will not run 
		//if the item in stock subtracted from the counter variable is less than 0
		if (itemsAvaliable_Amount[index] > 0 && itemsAvaliable_Amount[index] - counter >= 0)
		{
			//money equation :[
			if (money - (itemsAvaliable_Price[index] * counter) > 0)
			{
				//add item to inventory
				updatedInventory[x] = itemsAvaliable_Name[index];
				money -= (itemsAvaliable_Price[index] * counter);

				//add the amount of product that the user bought and add it to their inventory
				for (int i = 0; i < counter; i++)
				{
					updatedAmount[x]++;
				}

				x++;
			}
			else
			{
				// if the user does not have enough money, will return next line
				return "You do not have enough money.";
			}
		}
		else
		{
			// if there are no products left, will return next line
			return "Product not in stock.";
		}
		//the next line updates the inventory variable
		inventory_name = updatedInventory;

		//returns the value that is successful
		return "Successfully bought " + counter + " " + itemsAvaliable_Name[index] + "(s).";
	}

	//method that returns the current items to the console for the viewer to read based on the parameter
	public String returnItem(int index)
	{
		return itemsAvaliable_Name[index] + "\nAmount: " + itemsAvaliable_Amount[index] + "\n" + "Price: $" + formatter.format(itemsAvaliable_Price[index]);
	}

	/**
	 * The method creates three empty strings (result_1, result_2, and result_3) 
	 * and an integer variable named "biggest" which is assigned the value returned by a method named "getHighestCharacters()".
     * It then uses three for loops to iterate through three arrays (itemsAvaliable_Name, itemsAvaliable_Price,
     * and itemsAvaliable_Amount) and moves the values of the arrays to the result strings (result_1, result_2, and result_3) respectively, 
	 * also adding a comma after each item.
     * It then uses another for loop to add spaces after each item in the string, the number of spaces is 
	 * determined by the variable biggest subtracted from the length of the result string plus 2.
     * Finally, the console adds the three strings (result_1, result_2, and result_3) with new line characters 
	 * between them and returns the combined string in order to achieve an organized look.
	 */
	public String returnAll()
	{
		String result_1 = "";
		String result_2 = "";
		String result_3 = "";
		int biggest = getHighestCharacters();

		for (int i = 0; i < itemsAvaliable_Name.length; i++)
		{
			result_1 += itemsAvaliable_Name[i] + ",";

			int space = (biggest - result_1.length()) + 2;
			//spaces
			for (int j = 0; j < space; j++)
			{
				result_1 += " ";
			}
		}
		for (int i = 0; i < itemsAvaliable_Price.length; i++)
		{
			result_2 += "$" + formatter.format(itemsAvaliable_Price[i]) + ",";

			int space = (biggest - result_2.length()) + 2;

			//spaces
			for (int j = 0; j < space; j++)
			{
				result_2 += " ";
			}
		}
		for (int i = 0; i < itemsAvaliable_Amount.length; i++)
		{
			result_3 += "Amount: " + itemsAvaliable_Amount[i] + ",";

			int space = (biggest - result_3.length()) + 2;
			//spaces
			for (int j = 0; j < space; j++)
			{
				result_3 += " ";
			}
		}

		return result_1 + "\n" + result_2 + "\n" + result_3;
	}
	
	/**
	 * The method uses a for loop to iterate through an array named "inventory_name". For each iteration, 
	 * it concatenates the current item in the "inventory_name" array, an open parenthesis, the corresponding item 
	 * from an array named "inventory_amount" and a closed parenthesis and space. And then it combines
	 * it to the "result" string.
	 * @return result
	 */
	public String returnInventory()
	{
		String result = "";
		for (int i = 0; i < inventory_name.length; i++)
		{
			result += i + ") " + inventory_name[i] + " (" + inventory_amount[i] + "),  ";
		}

		return result;
	}
	//method that adds money to one's current balance split between five methods
	public void addPennies(int pennies)
	{
		this.pennies += pennies;
	}
	public void addDimes(int dimes)
	{
		this.dimes += dimes;
	}
	public void addQuarters(int quarters)
	{
		this.quarters += quarters;
	}
	public void addNickels(int nickels)
	{
		this.nickels += nickels;
	}

	//returning methods
	public double getMoney()
	{
		addMoney();
		return Double.parseDouble(formatter.format(money));
	}
	public int getPennies()
	{
		return pennies;
	}
	public int getQuarters()
	{
		return quarters;
	}
	public int getNickels()
	{
		return nickels;
	}
	public int getDimes()
	{
		return dimes;
	}
	public int getAmountOfItems()
	{
		return itemsAvaliable_Amount.length;
	}
	public String[] getInventory()
	{
		return inventory_name;
	}
}
