package lab1;


import java.util.Scanner;

public class Main {
	public static Scanner scanner;

	public static void main(String[] args)
	{
		scanner = new Scanner(System.in);

		print("task 1: " + calculateKollatzSequence(scanner.nextInt()));
		print("task 2: " + sequenceSum(scanner.nextInt()));
		print("task 3: " + findTreasure(scanner.nextInt(), scanner.nextInt()));
		print("task 4: " + calculateMaximin());
		print("task 5: " + (isEvenTwice(scanner.nextInt()) ? "yes" : "no"));
	}


	public static int calculateKollatzSequence(int n)
	{
		if (n == 1)
		{
			return 0;
		}

		if (n % 2 == 0)
		{
			return 1 + calculateKollatzSequence(n / 2);
		}

		return 1 + calculateKollatzSequence(3 * n + 1);
	}

	public static int sequenceSum(int n)
	{
		int answer = 0;

		for (int i = 0; i < n ; i++){
			print("enter num:");
			int num = scanner.nextInt();

			if(i % 2 == 0)
			{
				answer += num;
			}
			else
			{
				answer -= num;
			}
		}

		return answer;
	}

	public static int findTreasure(int x, int y)
	{
		int answer = -1;
		int stepCounter = 0;
		int tmpX = 0, tmpY = 0;

		String direction = scanner.next();
		while (!direction.equals("stop"))
		{
			int num = scanner.nextInt();

			switch (direction)
			{
				case "north":
					tmpY += num;

					break;
				case "south":
					tmpY -= num;

					break;
				case "west":
					tmpX -= num;

					break;
				case "east":
					tmpX += num;

					break;
				default:
					break;
			}

			stepCounter++;
			direction = scanner.next();

			if (
				tmpX == x
				&& tmpY == y
				&& answer == -1
			)
			{
				answer = stepCounter;
			}
		}

		return answer;
	}

	public static String calculateMaximin()
	{
		int n = scanner.nextInt();

		int answer = 0;
		int road = 0;

		for (int i = 1; i <= n; ++i) {
			int m = scanner.nextInt();
			int minVal = scanner.nextInt();

			for (int j = 1; j < m; ++j)
			{
				minVal = Math.min(minVal, scanner.nextInt());
			}

			if(minVal >= answer)
			{
				road = i;
			}

			answer = Math.max(answer, minVal);
		}

		return road + "," + answer;
	}

	public static boolean isEvenTwice(int n)
	{
		if(
			n < 100
			|| n > 999
		)
		{
			print("number must be three-digit!");

			return false;
		}

		int tmp;
		int sum = 0;
		int product = 1;

		while(n > 0)
		{
			tmp = n % 10;

			sum += tmp;
			product *= tmp;
			n /= 10;
		}

		return
				sum % 2 == 0
				&& product % 2 == 0
			;
	}

	private static void print(String text)
	{
		System.out.println(text);
	}
}