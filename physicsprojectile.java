package writing; 

import java.util.Scanner; 
public class physicsprojectile {
	

	public static void main(String[] args) {
		String wantInput = "";
		String timeStr = "time";
		String disStr = "distance";
		String both = "both";
		
		String disUnit, timeUnit; 


		double height; 
		double Vi; 
		double angle; 
		double Vx; 
		double Vy; 
		double time; 
		double quad; 
		double VxR; 
		double VyR; 
		double distance; 
		double timeDis, height_wTime; 
		
		double maxHeight;
		
		String timeFinal, disFinal, timeHeight; 
		

		

		Scanner input = new Scanner(System.in);
		
		//what do you want?
		System.out.print("What do you want to find?: ");
		wantInput = input.nextLine();
		
		wantInput = wantInput.toLowerCase();
		
		System.out.print("What is your time unit(ex: seconds, minutes, etc.): ");
		timeUnit = input.nextLine();
		System.out.print("What is your distance unit(ex: feet, meters, etc.): ");
		disUnit = input.nextLine();
		
		disUnit = disUnit.toLowerCase();
		timeUnit = timeUnit.toLowerCase(); 
		

		//Tries to identify what the input is -Yes you could also use the .equals("") method with specific stirngs
		if(wantInput.equals(timeStr) == false && wantInput.equals(disStr) == false && wantInput.equals(both) == false) {
			System.out.println("Invalid cmd");
			System.out.println("Your input: " + wantInput);
			System.out.println("cmds\n Time: give the amount of airtime\n Distance: give the x distance that the object travels\n Both: gives both the time and distance");
		}
		else {
			System.out.print("Height: ");
			height = input.nextDouble(); 
			System.out.print("Vi: ");
			Vi = input.nextDouble(); 
			System.out.print("Angle: ");
			angle = input.nextDouble(); 

			VxR = Math.toRadians(angle);
			VyR = Math.toRadians(angle);

			Vx = Vi * Math.cos(VxR); 
			Vy = Vi * Math.sin(VyR);


			quad = -Vy - Math.sqrt((Vy * Vy) - 4 * -4.9 * height);
			time = quad / (2 * -4.9);

			distance = Vx * time; 

			timeFinal = (Math.round(time * 100.0)/100.0 + " " + timeUnit);
			
			disFinal = (Math.round(distance * 100.0)/100.0 + " " + disUnit);
			
			
			if(wantInput.equals(timeStr)){
				
				
				timeUnit = timeUnit.toLowerCase(); 
				timeFinal = (Math.round(time * 100.0)/100.0 + timeUnit);
				
				System.out.println(timeFinal);
		
			}
			//distance
			else if(wantInput.equals(disStr)){
				
				
	
				disFinal = (Math.round(distance * 100.0)/100.0 + disUnit);
				
				System.out.println(disFinal);

				


			}
			//Both time and distance
			else if (wantInput.equals(both)) {
				
				
				
				
				
				
				timeFinal = (Math.round(time * 100.0)/100.0 + timeUnit);
				
				disFinal = (Math.round(distance * 100.0)/100.0 + disUnit);
				
				System.out.println(timeFinal);
				System.out.println(disFinal);

			}
	 		else{
	 			System.out.println("Invalid cmd");
				System.out.println("Your input: " + wantInput);
				System.out.println("cmds\n time: give the amount of airtime\n distance: give the x distance that the object travels\n both: gives both the time and distance");
				
				
			}
			
			


			//This is just another feature added to get time at a certain height - cmds: yes
			System.out.print("Would you like to know a height at a time?: ");
			
			timeHeight = input.next();
			timeHeight = timeHeight.toLowerCase();
			
			
			
			
			
			if (timeHeight.equals("yes") ) {
				System.out.print("What time?: ");
				timeDis = input.nextDouble();
				height_wTime = height + Vy * timeDis + (-4.9) * (timeDis * timeDis); 
				height_wTime = (Math.round(height_wTime * 100.0)/100.0); 
				
				
				if(timeDis < 0 || timeDis > time) {
					System.out.println("Time given: " + time + " invalid with the total airtime");
					
					System.out.println("Time: " + time + "input time: "+timeDis);
				}
				else {
					
					
					
					maxHeight = height + Vy * time/2  + (-4.9) * (time/2  * time/2);  
					maxHeight = (Math.round(maxHeight * 100.0)/100.0); 
				
					System.out.println("At " + timeDis + " sec the height is " + height_wTime + disUnit);
					System.out.println("Max height: " + maxHeight + disUnit);
				}
				
				
			
		}
			else {
				System.out.println("Invalid input: " + timeHeight);
				System.out.println("cmds: \nyes to continue");
			}
			
		}
		
		
			
	}
		
}

