package turismo_capitulo_I;

public class View {
	
	//	Para que te funcione en eclipse busca el pluging ANSI escape in console
	//  en el MarketPlace he instalarlo, reinicia eclipse y listo.
	
	private static String black = "\033[30m";
    public static String red = "\033[31m"; 
    public static String green = "\033[32m"; 
    private static String yellow = "\033[33m"; 
    public static String blue = "\033[34m"; 
    private static String purple = "\033[35m"; 
    public static String cyan = "\033[36m"; 
    private static String white = "\033[37m";
    private static String reset = "\u001B[0m";
    
    @SuppressWarnings("unused")
	public static void colorearMensaje(String color, String mensaje) { System.out.println(color + mensaje + reset); }
	
	public static void dataLoaderMenu() {
		
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		colorearMensaje(green,"[                                                                     ]");
		colorearMensaje(green,"[                 WELCOME TO TOURISM IN MIDDLE EARTH                  ]");
		colorearMensaje(green,"[                                                                     ]");
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		colorearMensaje(green,"[                Loading Attractions to The System...                 ]");
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		colorearMensaje(green,"[                Loading Promotions to The System...                  ]");
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		colorearMensaje(green,"[                   Loading Users to the system...                    ]");
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		
	}
	
	public static void ready() {
		/*
		System.out.println("[---------------------------------------------------------------------]");
		System.out.println("[                        READY-TO-USE SYSTEM                          ]");
		System.out.println("[---------------------------------------------------------------------]");
		*/
		
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		colorearMensaje(green,"[                        READY-TO-USE SYSTEM                          ]");
		colorearMensaje(green,"[---------------------------------------------------------------------]");
	}
	
	public static void warning() {
		
		System.out.println("[---------------------------------------------------------------------]");
		System.out.println("[              Warning - Error in the use of the System               ]");
		System.out.println("[---------------------------------------------------------------------]");
		
	}
	
	public static void userMenu() {
		
		System.out.println(" ");
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		colorearMensaje(yellow,"[               Choose your User with the ID number !!                ]");
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
						
		for(User user: LoadUsers.getUserList()) {
						
			System.out.println("[ ID: " + user.getId() + " " + user.getName());
						
		}
		
	}
	
	public static void welcomeMenu() {
		
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		colorearMensaje(yellow,"[                               Welcome                               ]");
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		System.out.println();
		
	}
	
	public static void mainMenu() {
		
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		colorearMensaje(yellow,"[ 1 - Promotions                                                      ]");
		colorearMensaje(yellow,"[ 2 - Attractions                                                     ]");
		colorearMensaje(yellow,"[ 3 - Your shopping                                                   ]");
		colorearMensaje(yellow,"[ 4 - Your current situation                                          ]");
		colorearMensaje(yellow,"[ 5 - Print your purchases                                            ]");
		colorearMensaje(yellow,"[ 6 - Print the purchases of each User                                ]");
		colorearMensaje(yellow,"[ 0 - Back                                                            ]");
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		
	}
	
	public static void promotionsMenu() {
		
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		colorearMensaje(yellow,"[ 1 - See all promotions with your timeUser limit                     ]");
		colorearMensaje(yellow,"[ 2 - See all promotions                                              ]");
		colorearMensaje(yellow,"[ 3 - To buy                                                          ]");
		colorearMensaje(yellow,"[ 0 - Back                                                            ]");
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		
	}
	
	public static void bannerPromotions() {
		
		System.out.println(" ");
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		colorearMensaje(yellow,"[                          Our Promotions!!!                          ]");
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		
	}
	
	public static void attractionMenu() {
		
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		colorearMensaje(yellow,"[ 1 - See all the attractions according to your preferences           ]");
		colorearMensaje(yellow,"[ 2 - See all attractions                                             ]");
		colorearMensaje(yellow,"[ 3 - To buy                                                          ]");
		colorearMensaje(yellow,"[ 0 - Back                                                            ]");
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		
	}
	
	public static void bannerAttractions() {
		
		System.out.println(" ");
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		colorearMensaje(yellow,"[                         Our Attractions!!!                          ]");
		colorearMensaje(yellow,"[---------------------------------------------------------------------]");
		
	}
	
	public static void line() {
		
		System.out.println("[---------------------------------------------------------------------]");
		
	}
	
	public static void buyAttractionMenu() {
		
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		colorearMensaje(green,"[ Choose the 'ID' of the 'Attraction to purchase'                     ]");
		colorearMensaje(green,"[ Or '0' to go back                                                   ]");
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		
	}
	
	public static void buyPromotionMenu() {
		
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		colorearMensaje(green,"[ Choose the 'ID' of the 'Promotion to purchase'                      ]");
		colorearMensaje(green,"[ Or '0' to go back                                                   ]");
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		
	}
	
	
	public static void noBuyMenu() {
		
		colorearMensaje(red,"[---------------------------------------------------------------------]");
		colorearMensaje(red,"[ 0 - Back                                                            ]");
		colorearMensaje(red,"[---------------------------------------------------------------------]");
		
	}
	
	public static void currentSituation() {
		
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		colorearMensaje(green,"[                       Your current situation                        ]");
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		

		colorearMensaje(green,"[ '" + Model.user.getName() + "', your budget is " + Model.user.getBudget() + ", and you have " + Model.user.getTime() + " Hs");
		colorearMensaje(green,"[  and your preference is: " + Model.user.getPreferences());
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		//System.out.println();

	}
	
	public static void greetings() {
		colorearMensaje(green,"[---------------------------------------------------------------------]");
		colorearMensaje(green,"[                        ENJOY THE ADVENTURE!!!                       ]");
		colorearMensaje(green,"[---------------------------------------------------------------------]");
	}
	
	

}
