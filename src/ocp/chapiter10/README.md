								Lambdas And Functional Interfaces
								

# Writing Simple Lambdas: (Écrire des lambdas simples)  
Java est un langage orienté objet dans l'âme. Vous avez déjà vu de nombreux objets. Dans Java 8, le langage a ajouté la possibilité d'écrire du code en utilisant un autre style.   
La programmation fonctionnelle est une manière d'écrire du code de manière plus déclarative. Vous spécifiez ce que vous voulez faire plutôt que de vous occuper de l'état des objets. Vous vous concentrez davantage sur les expressions que sur les boucles.  
La programmation fonctionnelle utilise des expressions lambda pour écrire du code. Une expression lambda est un bloc de code qui est transmis. Vous pouvez considérer **une expression lambda** comme **une méthode sans nom**. Elle a des paramètres et un corps comme les méthodes à part entière, mais elle n’a pas de nom comme une vraie méthode. Les expressions lambda sont souvent appelées lambdas pour faire court. Vous pourriez également les considérer comme des fermetures si Java n’est pas votre premier langage. Si vous avez eu une mauvaise expérience des fermetures (closures) dans le passé, ne vous inquiétez pas. Ils sont beaucoup plus simples en Java.      
En d'autres termes, une expression lambda est comme une méthode que vous pouvez passer comme s'il s'agissait d'une variable. Par exemple, il existe différentes façons de calculer l'âge. Une année humaine équivaut à sept années canines. Vous voulez écrire une méthode qui prend une méthode age() comme entrée. Pour ce faire dans un programme orienté objet, vous devez définir une sous-classe Human et une sous-classe Dog. Avec lambdas, vous pouvez simplement passer l'expression appropriée pour calculer l'âge.   
Seules les expressions lambda les plus simples figurent dans cet examen. Le but est de vous familiariser avec la syntaxe et les concepts. Cela signifie que vous ne faites pas encore vraiment de programmation fonctionnelle. Vous verrez à nouveau les lambdas à l'examen 1Z0-816.   
Dans cette section, nous allons couvrir un exemple de pourquoi les lambdas sont utilées et la syntaxe des lambdas    
### Pourquoi on utilise les expression Lambda:   
Une  expression lambda implémente une interface fonctionnelle en définissant une **seule** méthode anonyme (sans nom) qui peut être passée en argument à une méthode. Par conséquent, on peut dire que les expressions lambda nous permettent d'écrire du code fonctionnel.   
Les avantages d'utiliser les expressions lambda sont:   
* Avoir un code lisible et concis (مختصر) (factoriser un comportement) : cela peut aider à supprimer un grand nombre de lignes de leur code.   
* Faciles à utiliser avec les APIs conçues à l'aide d'expressions lambda (comme les API Stream).

### Lambda Example: (Exemple Lambda)   
Notre objectif est d'afficher tous les animaux dans une liste selon certains critères. Nous allons vous montrer comment faire cela sans lambdas pour illustrer à quel point les lambdas sont utiles. Nous commençons avec la classe Animal:   

	 public class Animal {
		 private String species;
		 private boolean canHop;
		 private boolean canSwim;
		 
		 public Animal(String speciesName, boolean hopper, boolean swimmer) {
			 species = speciesName;
			 canHop = hopper;
			 canSwim = swimmer;
		 }
		 
		 public boolean canHop() { return canHop; }
		 public boolean canSwim() { return canSwim; }
		 public String toString() { return species; }
	}
La classe Animal a trois variables d'instance, qui sont définies dans le constructeur. Il a deux méthodes qui déterminent si l'animal peut sauter ou nager. Il a également une méthode toString () afin que nous puissions facilement identifier l'animal dans les programmes.  
Nous prévoyons d'écrire beaucoup de contrôles différents, nous voulons donc une interface. Vous en apprendrez plus sur les interfaces dans le chapitre suivant. Pour l'instant, il suffit de se rappeler qu'une interface spécifie les méthodes que notre classe doit implémenter:  

		public interface CheckTrait {
			boolean test(Animal a);
		} 
La première chose que nous voulons vérifier est de savoir si l'animal peut sauter. Nous fournissons une classe qui peut vérifier ceci:  

		public class CheckIfHopper implements CheckTrait {
			@Override
			public boolean test(Animal a) {
				return a.canHop();
			}
		}
Cette classe peut sembler simple - et elle l'est. Cela fait en fait partie du problème que les lambdas résolvent. Reste un peu avec nous. Maintenant, nous avons tout ce dont nous avons besoin pour écrire notre code pour trouver les animaux qui sautent:   

	public class ExempleLambda {
		public static void main(String[] args) {
			List<Animal> animals = new ArrayList<Animal>(); // list of animals
			animals.add(new Animal("fish", false, true));
			animals.add(new Animal("kangaroo", true, false));
			animals.add(new Animal("rabbit", true, false));
			animals.add(new Animal("turtle", false, true));
			
			print(animals, new CheckIfHopper()); // pass class that does check
		}
		
		private static void print(List<Animal> animals, CheckTrait checker) {
			for (Animal animal : animals) {
				if (checker.test(animal)) // the general check
					System.out.print(animal + " ");
			}
			System.out.println();
		}
	}
La méthode print() est très générale - elle peut vérifier n'importe quel trait. C'est une bonne conception. Il ne devrait pas avoir besoin de savoir ce que nous recherchons spécifiquement pour afficher une liste d’animaux.    
Maintenant, que se passe-t-il si nous voulons imprimer les animaux qui nagent? Nous devons écrire une autre classe CheckIfSwims, ce n'est pas térible !  
Pourquoi ne pouvons-nous pas simplement spécifier la logique qui nous tient à cœur ici? Il s'avère que nous pouvons avec des expressions lambda. Nous pourrions répéter tout ce cours ici et vous faire trouver la seule ligne qui a changé. Au lieu de cela, nous allons simplement vous montrer. Nous pourrions remplacer la ligne 9 par ce qui suit, qui utilise un lambda:  

		print(animals, a -> a.canHop());
Ne vous inquiétez pas, la syntaxe semble un peu géniale. Vous vous y habituerez et nous le décrirons dans la section suivante. Nous expliquerons également les éléments qui ressemblent à de la magie. Pour l'instant, concentrez-vous simplement sur la facilité de lecture. Nous disons à Java que nous ne nous soucions que des animaux qui peuvent sauter.   
Il ne faut pas beaucoup d’imagination pour déterminer comment on ajouterait de la logique pour que les animaux sachent nager. Nous n'avons qu'à ajouter une ligne de code sans avoir besoin d'une classe supplémentaire pour faire quelque chose de simple. Voici cette autre ligne:  

		print(animals, a -> a.canSwim()); 
Et les animaux qui ne savent pas nager ?  

		print(animals, a -> !a.canSwim());
Le point ici est qu'il est vraiment facile d'écrire du code qui utilise des lambdas une fois que vous avez mis les bases en place. Ce code utilise un concept appelé exécution différée *Deferred execution*. L'exécution différée signifie que le code est spécifié maintenant mais qu'il s'exécutera plus tard. Dans ce cas, c'est plus tard que la méthode print() l'appelle.     

		// use Lambda expression
		print(animals, a-> a.canHop());	// kangaroo rabbit
		print(animals, a-> !a.canHop());	// fish turtle
### Lambda Syntax: (syntaxe Lambda)  
L'une des expressions lambda les plus simples que vous pouvez écrire est celle que vous venez de voir:   

		a -> a.canHop();
Les lambdas fonctionnent avec des interfaces qui n'ont qu'une **seule méthode abstraite**. Dans ce cas, Java regarde l'interface CheckTrait qui a une seule méthode.   
Le Lambda indique que Java doit appeler une méthode avec un paramètre Animal qui renvoie une valeur booléenne qui est le résultat de a.canHop().   
Java répond sur le contexte lors de la détermination de la signification des expressions lambda. Nous passons ce lambda comme deuxième paramètre de la méthode print(). Cette méthode attend un CheckTrait comme deuxième paramètre. Puisque nous passons un lambda à la place, Java essaie de mapper notre lambda à cette interface:  

	boolean test(Animal a);
Étant donné que la méthode de cette interface prend un animal, cela signifie que le paramètre lambda doit être un animal. Et puisque la méthode de cette interface renvoie un booléen, nous savons que le lambda renvoie un booléen.   
La syntaxe des lambdas est délicate car de nombreuses parties sont facultatives. Ces deux lignes font exactement la même chose:   

		a -> a.canHop()
		(Animal a) -> { return a.canHop(); }
Voyons ce qui se passe ici. Le premier exemple, illustré à la figure ci-dessous, comprend trois parties:   
* Un seul paramètre spécifié avec le nom a.
* L'opérateur de flèche pour séparer le paramètre et le corps.
* Un corps qui appelle une seule méthode et renvoie le résultat de cette méthode.   

		a -> a.canHop() // a parameter name, (->) arrow, a.canHop() bady
Le deuxième exemple comporte également trois parties, c'est juste plus bavard   

	(Animal a) -> { return a.canHop(); } // {} et ; required because in block
Les parenthèses ne peuvent être omises que s'il existe un seul paramètre et que son type n'est pas explicitement indiqué. Java fait cela parce que les développeurs utilisent généralement les expressions lambda de cette façon et qu'ils peuvent faire le moins de frappe possible.   
Regardons quelques exemples de lambdas valides. Prétendez qu'il existe des interfaces valides qui peuvent consommer un lambda avec zéro, un ou deux paramètres String.   

		() -> true // 0 parameters
		a -> a.startsWith("test") // 1 parameter
		(String a) -> a.startsWith("test") // 1 parameter
		(a, b) -> a.startsWith("test") // 2 parameters
		(String a, String b) -> a.startsWith("test") // 2 parameters
Assurez-vous maintenant que vous pouvez identifier une syntaxe incorrecte. Voyez-vous ce qui ne va pas avec chacun de ces éléments ?   

		print(a, b -> a.startsWith("test")); // DOES NOT COMPILE Missing parentheses
		print(a -> { a.startsWith("test"); }); // DOES NOT COMPILE Missing return
		print(a -> { return a.startsWith("test") }); // DOES NOT COMPILE Missing semicolon
		
# Coding Functional Interfaces:
Plus tôt dans le chapitre, nous avons déclaré l'interface CheckTrait, qui a exactement une méthode que les implémenteurs doivent écrire. Les Lambdas entretiennent une relation particulière avec de telles interfaces. En fait, ces interfaces ont un nom. Une interface fonctionnelle est une interface qui contient une seule méthode abstraite. Votre ami Sam peut vous aider à vous en souvenir car c'est officiellement connu sous le nom de règle de méthode abstraite unique (SAM).   

### Defining a Functional Interface (Définir une interface fonctionnelle):
Jetons un coup d'œil à un exemple d'interface fonctionnelle et à une classe qui l'implémente:  

	@FunctionalInterface
	public interface Sprint {
		public void sprint(int speed);
	}
	
	public class Tiger implements Sprint {
		public void sprint(int speed) {
			System.out.println("Animal is sprinting fast! " + speed);
		}
	}
	
Dans cet exemple, l'interface Sprint est une interface fonctionnelle car elle contient exactement une méthode abstraite et la classe Tiger est une classe valide qui implémente l'interface.   

Considérez les quatre interfaces suivantes. Compte tenu de notre précédente interface fonctionnelle Sprint, lesquelles parmi les suivantes sont des interfaces fonctionnelles ?  

	public interface Dash extends Sprint {}
	
	public interface Skip extends Sprint {
		void skip();
	}
	
	public interface Sleep {
		private void snore() {}
		default int getZzz() { return 1; }
	}
	
	public interface Climb {
		void reach();
		default void fall() {}
		static int getBackUp() { return 100; }
		private static boolean checkHeight() { return true; }
	}
	
Ces quatre interfaces sont valides, mais toutes ne sont pas des interfaces fonctionnelles.    
• L'interface Dash est une interface fonctionnelle car elle étend l'interface Sprint et hérite de la méthode abstraite unique sprint().   
• L'interface Skip n'est pas une interface fonctionnelle valide car elle possède deux méthodes abstraites : la méthode sprint() héritée et la méthode skip() déclarée.   
• L’interface Sleep n’est pas non plus une interface fonctionnelle valide. Ni snore() ni getZzz() ne répondent aux critères d’une seule méthode abstraite. Même si les méthodes par défaut fonctionnent comme des méthodes abstraites, dans le sens où elles peuvent être remplacées dans une classe implémentant l'interface, elles sont insuffisantes pour satisfaire l'exigence d'une seule méthode abstraite.    
• Enfin, l'interface Climb est une interface fonctionnelle. Bien qu’il définisse une multitude de méthodes, il ne contient qu’une seule méthode abstraite : reach().   

### Adding Object Methods (Ajout de méthodes d'objet):
Toutes les classes héritent de certaines méthodes d'Object. Pour l'examen, vous devez connaître les signatures de méthode Objet suivantes:  

• public String toString()   
• public boolean equals(Object)  
• public int hashCode()   

Nous en parlons maintenant car il existe une exception à la règle de la méthode abstraite unique que vous devriez connaître. Si une interface fonctionnelle inclut une méthode abstraite avec la même signature qu'une méthode publique trouvée dans Object, ces méthodes ne comptent pas pour le test de méthode abstraite unique. La motivation derrière cette règle est que toute classe qui implémente l'interface héritera d'Object, comme toutes les classes, et implémentera donc toujours ces méthodes.     

Jetons un coup d'œil à un exemple. La classe Soar est-elle une interface fonctionnelle ?   

	public interface Soar {
		abstract String toString();
	}
Ce n'est pas. Puisque toString() est une méthode publique implémentée dans Object, elle ne compte pas dans le test de méthode abstraite unique. D'autre part, l'implémentation suivante de Dive est une interface fonctionnelle:

	public interface Dive {
		String toString();
		public boolean equals(Object o);
		public abstract int hashCode();
		public void dive();
	}

La méthode dive() est la seule méthode abstraite, tandis que les autres ne sont pas comptées puisqu'il s'agit de méthodes publiques définies dans la classe Object.    

Méfiez-vous des exemples qui ressemblent à des méthodes de la classe Object mais qui ne sont pas réellement définis dans la classe Object. Voyez-vous pourquoi ce qui suit n'est pas une interface fonctionnelle valide ?   

	public interface Hibernate {
		String toString();
		public boolean equals(Hibernate o);
		public abstract int hashCode();
		public void rest();
	}
Bien qu'elle ressemble beaucoup à notre interface Dive, l'interface Hibernate utilise equals(Hibernate) au lieu de equals(Object). Étant donné que cela ne correspond pas à la signature de la méthode equals(Object) définie dans la classe Object, cette interface est considérée comme contenant deux méthodes abstraites : equals(Hibernate) et rest(), donc ce n'est pas une interface fonctionelle.   
# Using Method References (Utilisation des références de méthodes):
*Les références de méthode* sont un autre moyen de rendre le code plus facile à lire, par exemple en mentionnant simplement le nom de la méthode. Comme pour les lambdas, il faut du temps pour s'habituer à la nouvelle syntaxe. Dans cette section, nous montrons la syntaxe ainsi que les quatre types de références de méthode. Nous mélangeons également des lambdas avec des références de méthodes.    s
Supposons que nous codons duckling (un caneton) qui essaie d'apprendre à cancaner. Nous avons d’abord une interface fonctionnelle :

	public interface LearnToSpeak {
		void speak(String sound);
	}
Ensuite, nous découvrons que notre caneton a de la chance. Il existe une classe d'assistance avec laquelle le caneton peut travailler. Nous avons omis les détails de l'apprentissage du caneton à cancaner et laissé la partie qui appelle l'interface fonctionnelle :

	public class DuckHelper {
		public static void teacher(String name, LearnToSpeak trainer) {
			// Exercise patience (omitted)
			trainer.speak(name);
		}
	}
Enfin, il est temps de tout mettre en place et de rencontrer notre petit Caneton. Ce code implémente l'interface fonctionnelle à l'aide d'un lambda:   

	public class Duckling {
		public static void makeSound(String sound) {
			LearnToSpeak learner = s -> System.out.println(s);
			DuckHelper.teacher(sound, learner);
		}
	}

Pas mal. Il y a quand même un peu de redondance. Le lambda déclare un paramètre nommé s. Cependant, il ne fait rien d'autre que transmettre ce paramètre à une autre méthode. Une référence de méthode nous permet de supprimer cette redondance et d'écrire ceci:


	LearnToSpeak learner = System.out::println;
L'opérateur **::** indique à Java d'appeler la méthode println() ultérieurement. Il faudra un peu de temps pour s'habituer à la syntaxe. Une fois que vous l'aurez fait, vous constaterez peut-être que votre code est plus court et moins distrayant sans écrire autant de lambdas.


Une référence de méthode et un lambda se comportent de la même manière au moment de l'exécution. Vous pouvez prétendre que le compilateur transforme vos références de méthode en lambdas pour vous.  
Il existe **quatre formats** pour les références de méthode :  

• static methods (méthodes statiques)    
• Instance methods on a particular object (Méthodes d'instance sur un objet particulier)    
• Instance methods on a parameter to be determined at runtime (Méthodes d'instance sur un paramètre à déterminer au moment de l'exécution)   
• Constructors (Constructeurs)   

Jetons un bref coup d’œil à chacun d’eux tour à tour. Dans chaque exemple, nous montrons la référence de la méthode et son équivalent lambda. Pour l'instant, nous créons une interface fonctionnelle distincte pour chaque exemple. Dans la section suivante, nous présentons les interfaces fonctionnelles intégrées afin que vous n'ayez pas à continuer à écrire les vôtres.    
### Calling static Methods (Appel de méthodes statiques):
Pour le premier exemple, nous utilisons une interface fonctionnelle qui convertit un double en long:   

	interface Converter {
		long round(double num);
	}
Nous pouvons implémenter cette interface avec la méthode round() en Math. Ici, nous attribuons une référence de méthode et un lambda à cette interface fonctionnelle:   

		 StringStart anonymousInnerType= new Converter() {  //Anonymous 
			@Override
			public long round(double num) {
				return Math.round(num);
			}
		};
		
		Converter lambda = num -> Math.round(num); // lambda expression

		Converter methodRef = Math::round; // line 14 method reference
		
		System.out.println(methodRef.round(100.1)); // 100
À la ligne 14, nous référençons une méthode avec un paramètre, et Java sait que c'est comme un lambda avec un paramètre. De plus, Java sait transmettre ce paramètre à la méthode.   

Attends une minute. Vous savez peut-être que la méthode round() est surchargée : elle peut prendre un double ou un float. Comment Java sait-il que nous voulons appeler la version avec un double ? Avec à la fois les lambdas et les références de méthodes, Java déduit les informations du contexte. Dans ce cas, nous avons dit que nous déclarions un Converter, qui possède une méthode prenant un double paramètre. Java recherche une méthode qui correspond à cette description. S'il ne le trouve pas ou trouve plusieurs correspondances, le compilateur signalera une erreur. Cette dernière est parfois appelée erreur de type ambiguë.   
### Calling Instance Methods on a Particular Object (Appel de méthodes d'instance sur un objet particulier): 
Pour cet exemple, notre interface fonctionnelle vérifie si une String commence par une valeur spécifiée:    

	interface StringStart {
		boolean beginningCheck(String prefix);
	}
Idéalement, la classe String possède une méthode startWith() qui prend un paramètre et renvoie un booléen. Voyons comment utiliser les références de méthodes avec ce code:

		var str = "Zoo";
		
		StringStart anonymousInnerType = new StringStart() {
			@Override
			public boolean beginningCheck(String prefix) {
				return str.startsWith(prefix);
			}
		};

		StringStart lambda = prefix -> str.startsWith(prefix); 
		
		StringStart methodRef = str::startsWith; // line 19
		
		System.out.println(methodRef.beginningCheck("A")); // false
La ligne 19 montre que nous voulons appeler str.startsWith() et transmettre un seul paramètre à fournir au moment de l'exécution. Ce serait une bonne façon de filtrer les données dans une liste.   

Une référence de méthode ne prend de paramètres. Dans cet exemple, nous créons une interface fonctionnelle avec une méthode qui ne prend aucun paramètre mais renvoie une valeur:    

		String str = "";
		
		StringChecker methodRef = str::isEmpty; // line 19
		
		StringChecker lambda = () -> str.isEmpty();
		
		System.out.println(methodRef.check());
Puisque la méthode sur String est une méthode d’instance, nous appelons la référence de méthode sur une instance de la classe String.   

Bien que **toutes les références de méthodes puissent être transformées en lambdas**, l’**inverse** n’est pas toujours vrai. Par exemple, considérons ce code:

Comment pourrions-nous écrire ceci comme référence de méthode ? Vous pouvez essayer l'une des solutions suivantes :

	var str = "";
	StringChecker lambda = () -> str.startsWith("Zoo");
Comment pourrions-nous écrire ceci comme référence de méthode ? Vous pouvez essayer l'une des solutions suivantes:   

	StringChecker methodReference = str::startsWith; // DOES NOT COMPILE
	StringChecker methodReference = str::startsWith("Zoo"); // DOES NOT COMPILE
Aucun de ces deux éléments ne fonctionne! Bien que nous puissions transmettre le str dans le cadre de la référence de méthode, il n'y a aucun moyen de transmettre le paramètre "Zoo" avec. Par conséquent, il n’est pas possible d’écrire ce lambda comme référence de méthode.    
### Calling Instance Methods on a Parameter (Appel de méthodes d'instance sur un paramètre): 
Cette fois, nous allons appeler la même méthode d’instance qui ne prend aucun paramètre. Le problème est que nous le ferons sans connaître l’instance à l’avance. Nous avons besoin d'une interface fonctionnelle différente cette fois car elle doit connaître la chaîne:   

	interface StringParameterChecker {
		boolean check(String text);
	}
Nous pouvons implémenter cette interface fonctionnelle comme suit:

	StringParameterChecker methodRef = String::isEmpty; // line 23
	StringParameterChecker lambda = s -> s.isEmpty(); // line 24

	System.out.println(methodRef.check("Zoo")); // false
La ligne 23 indique que la méthode que nous voulons appeler est déclarée dans String. Cela ressemble à une méthode statique, mais ce n’est pas le cas. Au lieu de cela, Java sait que isEmpty() est une méthode d'instance qui ne prend aucun paramètre. **Java utilise le paramètre fourni au moment de l'exécution** comme instance sur laquelle la méthode est appelée.    

Comparez les lignes 23 et 24 avec les lignes 19 et 20 de notre exemple d'instance. Ils se ressemblent, bien que l’un fasse référence à une variable locale nommée str, tandis que l’autre ne fait référence qu’aux paramètres d’interface fonctionnelle.   

Vous pouvez même combiner les deux types de références de méthodes d’instance. Encore une fois, nous avons besoin d'une nouvelle interface fonctionnelle qui prend deux paramètres:   

	interface StringTwoParameterChecker {
		boolean check(String text, String prefix);
	}
Faites attention à l'ordre des paramètres lors de la lecture de l'implémentation:    

	26: StringTwoParameterChecker methodRef = String::startsWith; 
	27: StringTwoParameterChecker lambda = (s, p) -> s.startsWith(p);

	29: System.out.println(methodRef.check("Zoo", "A")); // false
Puisque l’interface fonctionnelle prend deux paramètres, Java doit déterminer ce qu’ils représentent. La première sera toujours l’instance de l’objet pour les méthodes d’instance. Tous les autres doivent être des paramètres de méthode.    
N'oubliez pas que la ligne 26 peut ressembler à une méthode statique, mais il s'agit en réalité d'une référence de méthode déclarant que l'instance de l'objet sera spécifiée ultérieurement. La ligne 27 montre une partie de la puissance d'une référence de méthode. Nous avons pu remplacer cette fois deux paramètres lambda.  
### Calling Constructors (Appeler des constructeurs):  
Une référence de constructeur est un type spécial de référence de méthode qui utilise new au lieu d'une méthode et instancie un objet. Pour cet exemple, notre interface fonctionnelle ne prendra aucun paramètre mais renverra une String:   

	interface EmptyStringCreator {
		String create();
	}
Pour appeler cela, nous utilisons new comme s'il s'agissait d'un nom de méthode:  

	30: EmptyStringCreator methodRef = String::new;
	31: EmptyStringCreator lambda = () -> new String();
	
	33: var myString = methodRef.create();
	34: System.out.println(myString.equals("Snake")); // false
Il se développe comme les références de méthodes que vous avez vues jusqu'à présent. Dans l'exemple précédent, le lambda n'a aucun paramètre.   
Les références de méthodes peuvent être délicates. Cette fois, nous créons une interface fonctionnelle qui prend un paramètre et renvoie un résultat:  

	interface StringCopier {
		String copy(String value);
	}
Dans l'implémentation, notez que la ligne 32 de l'exemple suivant a la même référence de méthode que la ligne 30 de l'exemple précédent:  

	32: StringCopier methodRef = String::new;
	33: StringCopier lambda = x -> new String(x);
	
	35: var myString = methodRef.copy("Zebra");
	36: System.out.println(myString.equals("Zebra")); // true
Cela signifie que vous ne pouvez pas toujours déterminer quelle méthode peut être appelée en consultant la référence de la méthode. Au lieu de cela, vous devez examiner le contexte pour voir quels paramètres sont utilisés et s'il existe un type de retour. Dans cet exemple, Java voit que nous transmettons un paramètre String et appelle le constructeur de String qui prend un tel paramètre.  
### Reviewing Method References (Révision des références de méthodes):  
La lecture des références de méthodes est utile pour comprendre le code. Le tableau 8.3 présente les quatre types de références de méthodes. Si ce tableau n’a pas de sens, veuillez relire la section précédente. Cela peut prendre quelques essais avant que les références de méthodes commencent à s'additionner.    

| Type                                    | Before colon (::)	   | After colon (::)   | Example           |
| ----------------------------------------|:----------------------:|:------------------:|:-----------------:|
| static methods                          | Class name             | Method name        | Math::random      |
| Instance methods on a particular object | Instance variable name | Method name        | str::startsWith   |
| Instance methods on a parameter         | Class name             | Method name        | String::isEmpty   |
| Constructor                             | Class name             | new                | String::new       |

# Working with Built-in Functional Interfaces (Travailler avec des interfaces fonctionnelles intégrées):
Il ne serait pas pratique d'écrire votre propre interface fonctionnelle à chaque fois que vous souhaitez écrire un lambda. Heureusement, un grand nombre d'interfaces fonctionnelles à usage général vous sont proposées. Nous les couvrons dans cette section.   

Les interfaces fonctionnelles de base du tableau 8.4 sont fournies dans le package java.util.function. Nous aborderons les génériques dans le chapitre suivant, mais pour l'instant, il vous suffit de savoir que <T> permet à l'interface de prendre un objet d'un type spécifié. Si un deuxième paramètre de type est nécessaire, nous utilisons la lettre suivante, U. Si un type de retour distinct est nécessaire, nous choisissons R pour return comme type générique.   

 **Common functional interfaces:**
 
| Functional interface    | Return type.   | Method name   |   # of parameters |
| ------------------------|:--------------:|:-------------:|:-----------------:|
| Supplier<T>             | T              | get()         | 0                 |
| Consumer<T>             | void           | accept(T)     | 1 (T)             |
| BiConsumer<T, U>        | void           | accept(T,U)   | 2 (T, U)          |
| Predicate<T>            | boolean        | test(T)       | 1 (T)             |
| BiPredicate<T, U>       | boolean        | test(T, U)    | 2 (T, U)          |
| Function<T, R>          | R              | apply(T)      | 1 (T)             |
| BiFunction<T, U, R>     | R              | apply(T,U)    | 2 (T, U)          |
| UnaryOperator<T>        | T              | apply(T)      | 1 (T)             |
| BinaryOperator<T>       | T              | apply(T,T)    | 2 (T, T)          |

Pour l'examen, vous devez mémoriser le tableau Nous vous donnerons beaucoup de pratique dans cette section pour vous aider à la rendre mémorable. Avant que vous ne le demandiez, la plupart du temps nous n’attribuons pas l’implémentation de l’interface à une variable. Le nom de l'interface est implicite et il est transmis directement à la méthode qui en a besoin. Nous introduisons les noms afin que vous puissiez mieux comprendre et vous souvenir de ce qui se passe. Dans le prochain chapitre, nous supposerons que vous avez compris cela et que vous arrêterez de créer la variable intermédiaire.   

Voyons comment implémenter chacune de ces interfaces. Étant donné que les références de méthodes et les lambdas    apparaissent partout dans l’examen, nous montrons une implémentation utilisant les deux lorsque cela est possible. Après avoir présenté les interfaces, nous abordons également certaines méthodes pratiques disponibles sur ces interfaces.   
### Implementing Supplier (Implementation de Fournisseur):
Un Supplier **fournisseur** est utilisé lorsque vous souhaitez générer ou fournir des valeurs sans prendre aucune entrée. L'interface Supplier est définie comme suit:  

	@FunctionalInterface
	public interface Supplier<T> {
		T get();
	}
Vous pouvez créer un objet LocalDate en utilisant la méthode factory now(). Cet exemple montre comment utiliser un Supplier pour appeler cette fabrique:  

	Supplier<LocalDate> s1 = LocalDate::now;
	Supplier<LocalDate> s2 = () -> LocalDate.now();

	LocalDate d1 = s1.get();
	LocalDate d2 = s2.get();

	System.out.println(d1); // 2022-02-20
	System.out.println(d2); // 2022-02-20
Cet exemple affiche une date deux fois. C’est également une bonne occasion de revoir les références de méthodes statiques. La référence de méthode LocalDate::now est utilisée pour créer un Supplier à affecter à une variable intermédiaire s1. Un Supplier est souvent utilisé lors de la construction de nouveaux objets. Par exemple, nous pouvons afficher deux objets StringBuilder vides:   

	Supplier<StringBuilder> s1 = StringBuilder::new;
	Supplier<StringBuilder> s2 = () -> new StringBuilder();
	
	System.out.println(s1.get()); // Empty string
	System.out.println(s2.get()); // Empty string
Cette fois, nous avons utilisé une référence de constructeur pour créer l'objet. Nous utilisons des génériques pour déclarer le type de Supplier que nous utilisons. Cela peut être un peu long à lire. Pouvez-vous comprendre ce que fait ce qui suit ? Procédez simplement étape par étape:  

	Supplier<ArrayList<String>> s3 = ArrayList::new;
	ArrayList<String> a1 = s3.get();
	System.out.println(a1); // []
Nous avons un Supplier d'un certain type. Ce type se trouve être ArrayList<String>. L'appel de get() crée ensuite une nouvelle instance de ArrayList<String>, qui est le type générique du fournisseur, en d'autres termes, un générique qui contient un autre générique. Assurez-vous de regarder attentivement le code lorsque ce genre de chose se produit.   

Remarquez comment nous avons appelé get() sur l'interface fonctionnelle. Que se passerait-il si nous essayions d'afficher s3 lui-même?  

	System.out.println(s3);
Ce code affiche:

	functionalinterface$$Lambda$3/0x0000000800c01410@3f99bd52
C'est le résultat de l'appel de toString() sur un lambda. Beurk. En fait, cela veut dire quelque chose. Notre classe de test s'appelle BuiltIns, et c'est dans un package que nous avons créé nommé FunctionalInterface. Vient ensuite $$, ce qui signifie que la classe n'existe pas dans un fichier de classe sur le système de fichiers. Il n'existe qu'en mémoire. Vous n’avez pas à vous soucier du reste.   

### Implementing Consumer and BiConsumer (Implementation de Consumer et BiConsumer):  
Vous utilisez un Consumer lorsque vous souhaitez faire quelque chose avec un paramètre mais ne rien renvoyer. BiConsumer fait la même chose, sauf qu'il prend deux paramètres. Les interfaces sont définies comme suit:   

	@FunctionalInterface
	public interface Consumer<T> {
		void accept(T t);
		// omitted default method
	}
	
	@FunctionalInterface
	public interface BiConsumer<T, U> {
		void accept(T t, U u);
		// omitted default method
	}
L'affichage est une utilisation courante de l'interface Consommateur:  

	Consumer<String> c1 = System.out::println;
	Consumer<String> c2 = x -> System.out.println(x);
	
	c1.accept("Annie"); // Annie
	c2.accept("Annie"); // Annie
BiConsumer est appelé avec deux paramètres. Il n’est pas nécessaire qu’ils soient du même type. Par exemple, nous pouvons mettre une clé et une valeur dans une Map en utilisant cette interface:  

	var map = new HashMap<String, Integer>();
	
	BiConsumer<String, Integer> b1 = map::put;
	BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
	
	b1.accept("chicken", 7);
	b2.accept("chick", 1);
	
	System.out.println(map); // {chicken=7, chick=1}
Le résultat est {chicken=7, chick=1}, ce qui montre que les deux implémentations BiConsumer ont été appelées. Lors de la déclaration de b1, nous avons utilisé une **référence de méthode d'instance sur un objet** puisque nous voulons appeler une méthode sur la map des variables locales. Le code pour instancier b1 est un peu plus court que le code pour b2. C’est sans doute pour cela que l’examen est si friand de références de méthodes.   


Comme autre exemple, nous utilisons le même type pour les deux paramètres génériques:   

	var map = new HashMap<String, String>();
	BiConsumer<String, String> b1 = map::put;
	BiConsumer<String, String> b2 = (k, v) -> map.put(k, v);
	
	b1.accept("chicken", "Cluck");
	b2.accept("chick", "Tweep");
	
	System.out.println(map); // {chicken=Cluck, chick=Tweep}
Cela montre qu'un BiConsumer peut utiliser le même type pour les paramètres génériques T et U.   
### Implementing Predicate and BiPredicate (Implementation de Predicate and BiPredicate):  
Le prédicat est souvent utilisé lors du filtrage ou de la correspondance. Les deux sont des opérations courantes. Un BiPredicate est comme un Predicate, sauf qu'il prend deux paramètres au lieu d'un. Les interfaces sont définies comme suit:   

	@FunctionalInterface
	public interface Predicate<T> {
		boolean test(T t);
		// omitted default and static methods
	}
	
	@FunctionalInterface
	public interface BiPredicate<T, U> {
		boolean test(T t, U u);
		// omitted default methods
	}
Vous pouvez utiliser un prédicat pour tester une condition.   

	Predicate<String> methodRef = String::isEmpty; 
	Predicate<String> lambda = s -> s.isEmpty(); 
	
	System.out.println(methodRef.test("")); // true
	System.out.println(lambda.test("")); // true
Cela affiche vrai deux fois. Plus intéressant est un BiPredicate. Cet exemple affiche également vrai deux fois:  

	BiPredicate<String, String> b1 = String::startsWith;
	BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
	
	System.out.println(b1.test("chicken", "chick")); // true
	System.out.println(b2.test("chicken", "chick")); // true
La référence de la méthode inclut à la fois la variable d'instance et le paramètre pour startupsWith(). C'est un bon exemple de la façon dont les références de méthodes permettent d'économiser beaucoup de saisie. L’inconvénient c’est qu’ils sont moins explicites, et il faut vraiment comprendre ce qui se passe!   
### Implementing Function and BiFunction (Implementation de Function et BiFunction):
Une fonction est chargée de transformer un paramètre en une valeur d'un type potentiellement différent et de le renvoyer. De même, une BiFunction est chargée de transformer deux paramètres en valeur et de la renvoyer. Les interfaces sont définies comme suit:   

	@FunctionalInterface
	public interface Function<T, R> {
		R apply(T t);
		// omitted default and static methods
	}
	
	@FunctionalInterface
	public interface BiFunction<T, U, R> {
		R apply(T t, U u);
		// omitted default method
	}
Par exemple, cette fonction convertit une chaîne en la longueur de la chaîne:   

	Function<String, Integer> f1 = String::length;
	Function<String, Integer> f2 = x -> x.length();
	
	System.out.println(f1.apply("cluck")); // 5
	System.out.println(f2.apply("cluck")); // 5
Cette fonction transforme une chaîne en un entier. Eh bien, techniquement, cela transforme la chaîne en un entier, qui est automatiquement transformé en un entier. Les types ne doivent pas nécessairement être différents. Ce qui suit combine deux objets String et produit une autre String:  

	BiFunction<String, String, String> b1 = String::concat;
	BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
	
	System.out.println(b1.apply("baby ", "chick")); // baby chick
	System.out.println(b2.apply("baby ", "chick")); // baby chick
Les deux premiers types de BiFunction sont les types d’entrée. Le troisième est le type de résultat. Pour la référence de la méthode, le premier paramètre est l'instance sur laquelle concat() est appelée et le second est transmis à concat().   
### Implementing UnaryOperator and BinaryOperator (Implementation de UnaryOperator et BinaryOperator):  
UnaryOperator et BinaryOperator sont des cas particuliers d'une fonction. Ils exigent que tous les paramètres de type soient du même type. Un UnaryOperator transforme sa valeur en une valeur du même type. Par exemple, incrémenter de un est une opération unaire. En fait, UnaryOperator étend Function. Un BinaryOperator fusionne deux valeurs en une seule du même type. L'addition de deux nombres est une opération binaire. De même, BinaryOperator étend BiFunction. Les interfaces sont définies comme suit:   

	@FunctionalInterface
	public interface UnaryOperator<T> extends Function<T, T> {
		// omitted static method
	}
	
	@FunctionalInterface
	public interface BinaryOperator<T> extends BiFunction<T, T, T> {
		// omitted static methods
	}
Cela signifie que les signatures de méthode ressemblent à ceci:  

	T apply(T t); // UnaryOperator
	T apply(T t1, T t2); // BinaryOperator
Dans le Javadoc, vous remarquerez que ces méthodes sont héritées de la superclasse Function/BiFunction. Les déclarations génériques sur la sous-classe forcent le type à être le même. Pour l'exemple unaire, remarquez que le type de retour est du même type que le paramètre.  

	UnaryOperator<String> u1 = String::toUpperCase;
	UnaryOperator<String> u2 = x -> x.toUpperCase();
	
	System.out.println(u1.apply("chirp")); // CHIRP
	System.out.println(u2.apply("chirp")); // CHIRP
Cela imprime CHIRP deux fois. Nous n'avons pas besoin de spécifier le type de retour dans les génériques car UnaryOperator exige qu'il soit identique au paramètre. Et maintenant voici l’exemple binaire:   

	BinaryOperator<String> b1 = String::concat;
	BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
	
	System.out.println(b1.apply("baby ", "chick")); // baby chick
	System.out.println(b2.apply("baby ", "chick")); // baby chick
Notez que cela fait la même chose que l’exemple BiFunction. Le code est plus succinct, ce qui montre l’importance d’utiliser la meilleure interface fonctionnelle. C'est bien d'avoir un type générique spécifié au lieu de trois.   
### Checking Functional Interfaces (Vérification des interfaces fonctionnelles):  
Il est très important de connaître le nombre de paramètres, les types, la valeur de retour et le nom de la méthode pour chacune des interfaces fonctionnelles. Ce serait le bon moment pour mémoriser le tableau 8.4 si vous ne l’avez pas déjà fait. Faisons quelques exemples pour pratiquer.    
Quelle interface fonctionnelle utiliseriez-vous dans ces trois situations ?

• Renvoie une chaîne sans prendre aucun paramètre   
• Renvoie un booléen et prend une chaîne   
• Renvoie un entier et prend deux entiers  

Le **premier** est un Supplier<String> car il génère un objet et ne prend aucun paramètre.  
Le **second** est un Function<String,Boolean> car il prend un paramètre et renvoie un autre type. C'est un peu délicat. Vous pourriez penser qu'il s'agit d'un Predicate<String>. Notez qu'un prédicat renvoie une primitive booléenne et non un objet booléen.   
Le **troisième** est soit un BinaryOperator<Integer>, soit un BiFunction<Integer,Integer,Integer>. Puisque BinaryOperator est un cas particulier de BiFunction, l’une ou l’autre est une réponse correcte. BinaryOperator<Integer> est la meilleure réponse des deux car elle est plus spécifique.    

Retentons cet exercice mais avec du code. C'est plus difficile avec le code. La première chose à faire est de regarder combien de paramètres prend le lambda et s'il existe une valeur de retour. Quelle interface fonctionnelle utiliseriez-vous pour remplir les espaces vides ?

	6: ______<List> ex1 = x -> "".equals(x.get(0));
	7: ______<Long> ex2 = (Long l) -> System.out.println(l);
	8: _______<String, String> ex3 = (s1, s2) -> false;
Predicate<List>
Suppler<Long>
BiPredicate<String, String>
La **ligne 6** transmet un paramètre List au lambda et renvoie un booléen. Cela nous indique qu'il s'agit d'un prédicat ou d'une fonction. Puisque la déclaration générique n'a qu'un seul paramètre, il s'agit d'un prédicat.      
La **ligne 7** transmet un paramètre Long au lambda et ne renvoie rien. Cela nous indique qu'il s'agit d'un Consumer.    
La **ligne 8** prend deux paramètres et renvoie un booléen. Lorsque vous voyez un booléen renvoyé, pensez Predicate à moins que les génériques ne spécifient un type de retour booléen. Dans ce cas, il y a deux paramètres, c'est donc un BiPredicate.    

Trouvez-vous cela facile ? Dans le cas contraire, consultez à nouveau le tableau 8.4. Nous ne plaisantons pas. Vous devez très bien connaître le tableau. Maintenant que vous venez d’étudier le tableau, nous allons jouer à « identifier l’erreur ». Ceux-ci sont censés être délicats:  

	6: Function<List<String>> ex1 = x -> x.get(0); // DOES NOT COMPILE
	7: UnaryOperator<Long> ex2 = (Long l) -> 3.14; // DOES NOT COMPILE
La **ligne 6** prétend être une fonction. Une fonction doit spécifier deux types génériques : le type de paramètre d’entrée et le type de valeur de retour. Le type de valeur de retour est absent de la ligne 6, ce qui empêche la compilation du code.   
La **ligne 7** est un UnaryOperator, qui renvoie le même type que celui transmis alors que l'exemple renvoie un double plutôt qu'un Long, ce qui empêche la compilation du code.    
### Using Convenience Methods on Functional Interfaces (Utiliser des méthodes pratiques sur les interfaces fonctionnelles):   
Par définition, toutes les interfaces fonctionnelles ont une seule méthode abstraite. Cela ne signifie pas pour autant qu’ils ne peuvent avoir qu’une seule méthode. Plusieurs interfaces fonctionnelles courantes fournissent un certain nombre de méthodes d'interface par défaut utiles. 

Le tableau ci-dessous, montre les méthodes pratiques sur les interfaces fonctionnelles intégrées que vous devez connaître pour l'examen. Tous ces éléments facilitent la modification ou la combinaison d’interfaces fonctionnelles du même type. Notez que le tableau montre uniquement les interfaces principales. Les interfaces BiConsumer, BiFunction et BiPredicate proposent des méthodes similaires.

| Interface instance    | Method return type   | Method name      | Method parameters     |
| ----------------------|:--------------------:|:----------------:|:---------------------:|
| Consumer              | Consumer             | andThen()        | Consumer              |
| Function              | Function             | andThen()        | Function              |
| Function              | Function             | compose()        | Function              |
| Predicate             | Predicate            | and()            | Predicat              |
| Predicate             | Predicate            | negate()         | —                     |
| Predicate             | Predicate            | or()             | Predicat              |

Commençons par ces deux variables de prédicat:  

	Predicate<String> egg = s -> s.contains("egg");
	Predicate<String> brown = s -> s.contains("brown");
Nous voulons maintenant un prédicat pour les œufs bruns et un autre pour toutes les autres couleurs d'œufs. Nous pourrions écrire ceci à la main, comme indiqué ici:  

	Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
	Predicate<String> otherEggs = s -> s.contains("egg") && !s.contains("brown");
Cela fonctionne, mais ce n'est pas génial. C’est un peu long à lire et il contient des doublons. Et si nous décidions que la lettre e devait être majuscule en œuf ? Nous devrions le modifier en trois variables : egg, brownEggs et otherEggs. Une meilleure façon de gérer cette situation consiste à utiliser deux des méthodes par défaut sur Predicate.     

	Predicate<String> brownEggs = egg.and(brown);
	Predicate<String> otherEggs = egg.and(brown.negate());
Soigné! Nous réutilisons maintenant la logique des variables Predicate d'origine pour en créer deux nouvelles. La relation entre les variables est plus courte et plus claire. Nous pouvons également changer l'orthographe de egg à un endroit, et les deux autres objets auront une nouvelle logique car ils y font référence.   

Passons maintenant à Consumer, examinons la méthode andThen(), qui exécute deux interfaces fonctionnelles en séquence:   

	Consumer<String> c1 = x -> System.out.print("1: " + x);
	Consumer<String> c2 = x -> System.out.print(",2: " + x);

	Consumer<String> combined = c1.andThen(c2);
	combined.accept("Annie"); // 1: Annie,2: Annie
Remarquez comment le même paramètre est transmis à c1 et c2. Cela montre que les instances Consumer sont exécutées en séquence et sont indépendantes les unes des autres.

En revanche, la méthode compose() sur Function enchaîne les interfaces fonctionnelles. Cependant, il transmet la sortie de l’un à l’entrée de l’autre.  

	Function<Integer, Integer> before = x -> x + 1;
	Function<Integer, Integer> after = x -> x * 2;

	Function<Integer, Integer> combined = after.compose(before);
	System.out.println(combined.apply(3)); // 8
Cette fois, l'avant s'exécute en premier, transformant le 3 en 4. Puis l'après s'exécute, doublant le 4 en 8. Toutes les méthodes de cette section sont utiles pour simplifier votre code lorsque vous travaillez avec des interfaces fonctionnelles.   
### Learning the Functional Interfaces for Primitives (Apprendre les interfaces fonctionnelles pour les primitives):   
Vous vous souvenez quand nous vous avons dit de mémoriser le tableau avec les interfaces fonctionnelles communes ? As-tu? Si ce n’est pas le cas, allez-y maintenant. Nous attendrons. Nous sommes sur le point de le rendre plus impliqué. Il existe également un grand nombre d'interfaces fonctionnelles spéciales pour les primitives. Ceux-ci sont utiles au chapitre 10 lorsque nous abordons les flux et les options.    

La plupart d’entre eux sont destinés aux types double, int et long. Il existe une exception, BooleanSupplier. Nous abordons cela avant de présenter les interfaces fonctionnelles pour double, int et long.   
##### Functional Interfaces for boolean ():
BooleanSupplier est un type distinct. Il a une méthode à mettre en œuvre:   

	@FunctionalInterface
	public interface BooleanSupplier {
		boolean getAsBoolean();
	}
Cela fonctionne exactement comme vous l’attendez des interfaces fonctionnelles. Voici un exemple:  

	12: BooleanSupplier b1 = () -> true;
	13: BooleanSupplier b2 = () -> Math.random()> .5;
	14: System.out.println(b1.getAsBoolean()); // true
	15: System.out.println(b2.getAsBoolean()); // false
Les lignes 12 et 13 créent chacune un BooleanSupplier, qui est la seule interface fonctionnelle pour boolean. La ligne 14 s'affiche vrai, puisque c'est le résultat de b1. La ligne 15 imprime vrai ou faux, selon la valeur aléatoire générée.   
##### Functional Interfaces for double, int, and long (Interfaces fonctionnelles pour double, int et long):
La plupart des interfaces fonctionnelles sont pour double, int et long. Le tableau ci-dessous montre l'équivalent du tableau 8.4 pour ces primitives. Vous ne serez probablement pas surpris de devoir le mémoriser. Heureusement, vous avez maintenant mémorisé le tableau 8.4 et pouvez appliquer ce que vous avez appris au ce tableau.   

| Functional interfaces    | Return type.   | Single abstract method   | # of parameters           |
| -------------------------|:--------------:|:------------------------:|:-------------------------:|
| DoubleSupplier           | double         | getAsDouble              | 0                         |
| IntSupplier              | int            | getAsInt                 | 0                         |
| LongSupplier             | long           | getAsLong                | 0                         |
| DoubleConsumer           | void           | accept                   | 1 (double)                |                                                                                
| IntConsumer              | void           | accept                   | 1 (int)                   |
| LongConsumer             | void           | accept                   | 1 (long)                  |
| DoublePredicate          | boolean        | test                     | 1 (double)                |
| IntPredicate             | boolean        | test                     | 1 (int)                   |
| LongPredicate            | boolean        | test                     | 1 (long)                  |
| DoubleFunction<R>        | R              | apply                    | 1 (double)                |
| IntFunction<R>           | R              | apply                    | 1 (int)                   |
| LongFunction<R>          | R              | apply                    | 1 (long)                  |
| DoubleUnaryOperator      | double         | applyAsDouble            | 1 (double)                |
| IntUnaryOperator         | int            | applyAsInt               | 1 (int)                   |
| LongUnaryOperator        | long           | applyAsLong              | 1 (long)                  |
| DoubleBinaryOperator     | double         | applyAsDouble            | 2 (double, double)        |
| IntBinaryOperator        | int            | applyAsInt               | 2 (int, int)              |
| LongBinaryOperator       | long           | applyAsLong              | 2 (long, long)            |

Il y a quelques points à noter qui diffèrent entre le tableau 8.4 et le tableau ci-dessus:    

• Les génériques ont disparu de certaines interfaces, et à la place le nom du type nous indique quel type primitif est impliqué. Dans d'autres cas, comme IntFunction, seul le type de retour générique est nécessaire car nous convertissons un int primitif en objet.  
• La méthode abstraite unique est souvent renommée lorsqu'un type primitif est renvoyé. En plus des équivalents du Tableau 8.4, certaines interfaces sont spécifiques aux primitives. Le tableau 8.7 les répertorie.   

Nous utilisons des interfaces fonctionnelles depuis un certain temps maintenant, vous devriez donc bien comprendre comment lire le tableau. Faisons un exemple juste pour être sûr. Quelle interface fonctionnelle utiliseriez-vous pour remplir le vide afin de compiler le code suivant?  

	var d = 1.0;
	_____________ f1 = x -> 1;
	f1.applyAsInt(d);
Lorsque vous voyez une question comme celle-ci, cherchez des indices. Vous pouvez voir que l'interface fonctionnelle en question prend un double paramètre et renvoie un int. Vous pouvez également voir qu’il possède une seule méthode abstraite nommée applyAsInt. Les interfaces fonctionnelles DoubleToIntFunction et ToIntFunction répondent à ces trois critères.
# Working with Variables in Lambdas: (Utilisation de variables dans Lambdas)  
Les variables peuvent apparaître aux **3** endroits par rapport aux lambdas: la liste des paramètres, les variables locales déclarées à l'intérieur du corps lambda et les variables référencées à partir du corps lambda. Tous les trois sont des occasions pour l'examen de vous tromper. Nous explorerons chacun d'entre eux afin que vous soyez alerte lorsque des astuces apparaissent! 
### Parameter List: (Liste des paramètres)   
Plus tôt dans ce chapitre, vous avez appris que la spécification du type de paramètres est facultative. En outre, var peut être utilisé à la place du type spécifique. cela signifie que ces trois déclarations sont interchangeables:   

		Predicate<String> p1 = x -> true;
		Predicate<String> p2 = (var x)  -> true;
		Predicate<String> p3 = (String x) -> true;
L'examen peut vous demander d'identifier le type du paramètre lambda. Dans notre exemple, la réponse est String. Comment avons-nous compris cela? Un lambda déduit les types à partir du contexte. Cela signifie que vous pouvez faire de même.		
Dans ce cas, le lambda est assigné à un Predicate qui prend une String. Un autre endroit pour rechercher le type est dans une signature de méthode, Regardons cet exemple:  

	public class WorkingWithVariablesInLambdas {
		public static void main(String[] args) { 
			consume((var x) -> System.out.println(x), 123);	// 123
			
			ArrayList<Integer> list =  new ArrayList<Integer>();
			list.add(13); list.add(-1);list.add(5);
			System.out.println("Avant: " + list);// Avant: [13, -1, 5]	
			counts(list);
			System.out.println("Après" + list);	// Après[-1, 5, 13]
		}
		private static void consume(Consumer<Integer> c, int num) {
			c.accept(num);
		}
		private static void counts(List<Integer> list) {
			list.sort((var x, var y) -> x.compareTo(y));
		}
	}
Si vous avez deviné Intger, c-a-d vous avez raison.    	
### Local Variables inside the Lambda Body: (Variables locales à l'intérieur du corps Lambda)   
Bien qu'il soit plus courant qu'un corps lambda soit une seule expression, il est légal de définir un bloc. Ce bloc peut contenir tout ce qui est valide dans un bloc Java normal, y compris les déclarations de variables locales.   
Le code suivant fait exactement cela. il crée une variable locale nommée c qui est étendue au bloc lambde.   

		(a, b) -> { int c = 0; return 5;}
Lors de l'écriture de votre propre code, un bloc lambda avec une variable locale est un bon indice que vous devriez extraire ce code dans une méthode.  

Maintenent regardant ce code:

		(a, b) -> { int a = 0; retrun 5; }	// DOES NOT COMPILE
Nous essayons de redéclarer la variable local "a", ce qui n'est pas autorisé. Java ne vous permet pas de créer une variable locale avec le même nom qu'une variable déjà déclarée dans **la même portée (scope).**   
Maintenant, essayons un exemple dur. Combien d'erreurs de syntaxe voyez-vous dans cette méthode ?   

		public void variables(int a) {
			int  b = 1;
			Predicate<Integer> p = a -> {	// ligne 3
				int b = 0;	// ligne 4
				int c = 0;
				return b == c;
			}// ligne 7 il manque ; à la fin
		}
Dans cette méthode il 3 erreurs:
* Ligne 3: La variable "a" était déjà utilisée dans cette portée comme paramètre de méthode.   
* ligne 4: Où le code tente de redéclarer la variable locale "b".  
* ligne 7: Il manque un point-virgule à la variable p1 à la fin du block.

### Variables Referenced from the Lambda Body: (Variables référencées à partir du corps Lambda)  
Les corps Lambda sont autorisés à référencer certaines variables du code environnant. 

		class Crow{
			private String color;
			public void caw(String name) { // name effectively final
				String volume = "loudly"; // volume effectively final
				Consumer<String> consumer = s -> 
				System.out.println(name + " says "
						+ volume + " that she is " + color);
			}
		}
Cela montre que lambda peut accéder à une variable d'instance, un paramètre de méthode ou une variable locale sous certaines conditions. Les variables d'instance (et les variables de classe) sont toujours autorisées.   

Les paramètres de méthode et les variables locales peuvent être référencés s'ils sont effectivement définitifs *effectively final*. En termes simples, les objets ou valeurs primitives sont **effectivement définitifs** si **nous ne modifions pas leurs valeurs après l'initialisation.**       
 
Si le code est toujours compilé, la variable est *effectively final*. Vous pouvez y penser comme si nous avions écrit ceci:

		class Crow{
			private String color;
			public void caw(final String name) { // name final et non effectively final
				final String volume = "loudly";	// volume final et non effectively final
				Consumer<String> consumer = s -> 
				System.out.println(name + " says "
						+ volume + " that she is " + color);
			}	
		}
Cela devient encore plus intéressant lorsque vous regardez où les erreurs du compilateur se produisent lorsque les variables ne sont pas *effectively final*. 

		class Crow{
			private String color;
			public void caw(String name) {
				String volume = "loudly";
				name= "Caty";
				color = "black";
				Consumer<String> consumer = s -> 
				System.out.println(name + " says "	// line 8
						+ volume + " that she is " + color); // line 9
				volume = "softly";	// line 10
			}
		}  
La variable local name n'est plus *effectively final*, donc la ligne 8 ne compile pas, la variable volume aussi n'est plus *effectively final* (elle modifier dans le ligne 10)  point de vue lambda c'est une erreur aussi mais le compliteur nous fait sortir que la ligne 8. Par conséquent, le lambda doit être celui qui génère l'erreur du compilateur.   

Règles d'accès à une variable à partir d'un corps lambda à l'intérieur d'une méthode:
* Variable permise: Instance variable, Static variable, Lambda parameter.
* Variable permise si elle est effectively final: Local variable, Method parameter.

### Règles d'accès à une variable depuis un corps lambda à l'intérieur une méthode:  (Rules for accessing a variable from a lambda body inside a method)
| Variable type    | Rule                         |                                                     
|------------------|:----------------------------:|
|Instance variable | Allowed                      |    
|Static variable   | Allowed                      |
|Local variable    | Allowed if effectively final |
|Method parameter  | Allowed if effectively final |
|Lambda parameter  | Allowed                      |

# Calling APIs with Lambdas: (Appeler des API avec Lambdas)  
Maintenant que vous êtes familiarisé avec lambda et les interfaces fonctionnelles, nous pouvons examiner les méthodes les plus courantes qui les utilisent lors de l'examen.    
### removeIf():  
List et Set déclarent une méthode removeIf() qui prend un Predicate. La signature de la méthode est la suivante:   

		default boolean removeIf(Predicate<? super E> filter)
Imaginez que nous ayons une liste de noms pour les lapins de compagnie. Nous décidons de supprimer tous les noms de lapin qui ne commencent pas par la lettre 'h'. Nous pourrions résoudre ce problème en écrivant une boucle. Ou nous pourrions le résoudre en une seule ligne:  

		public class CallingAPIsWithLambdas {
			public static void main(String[] args) {
				List<String> bunnies = new ArrayList<String>();
				bunnies.add("long ear");		
				bunnies.add("floppy");		
				bunnies.add("hoppy");
				System.out.println(bunnies);	// [long ear, floppy, hoppy]
				bunnies.removeIf(s -> s.charAt(0) != 'h');
				System.out.println(bunnies);	// [hoppy]
			}
		}
La méthode removeIf() fonctionne de la même façon avec Set.   
### sort():  
Désormais, on peut utiliser la nouvelle API de tri *Sort* ajoutée à *java.util.List* dans Java 8-au lieu de l'ancienne API *Collections.sort*. La signature de la méthode est la suivante: 

		default void sort(Comparator<? super E> c)
Pour trier une liste, vous pouvez appeler Collection.sort (liste), mais maintenant vous pouvez trier directement sur l'objet de liste: 

		public class CallingAPIsWithLambdas {
		   public static void main(String[] args) {
				List<String> bunnies = new ArrayList<String>();
				bunnies.add("long ear");		
				bunnies.add("floppy");		
				bunnies.add("hoppy");
				System.out.println(bunnies);	// [long ear, floppy, hoppy]
				bunnies.sort((b1, b2) -> b1.compareTo(b2));
				System.out.println(bunnies);	// [floppy, hoppy, long ear]
		   }
      }
### forEach():
Notre dernière méthode est forEach(). Elle prend un Consumer et appelle un lambda pour chaque éléments rencontré.   
La signature de la méthode est la suivante:  

		default void forEach(Consumer<? super T> action)
Regardons cet exemple:  

	  public class CallingAPIsWithLambdas {
		   public static void main(String[] args) {
			List<String> bunnies = new ArrayList<String>();
			bunnies.add("long ear");		
			bunnies.add("floppy");		
			bunnies.add("hoppy");
			System.out.println(bunnies);	// [long ear, floppy, hoppy]
			bunnies.forEach(b -> System.out.print(b + ", "));	// long ear, floppy, hoppy, 
		 }
     }
Pour une Map, vous devez choisir si vous souhaitez passer par les clés ou les valeurs:  

		Map<String, Integer> bun = new HashMap<>();
		bun.put("long ear", 3);		
		bun.put("floppy", 8);		
		bun.put("hoppy", 1);		
		bun.keySet().forEach(b -> System.out.println(b + " "));	// long ear, floppy, hoppy
		bun.values().forEach(b -> System.out.print(b + " "));	// 3, 8, 1
Il s'avère que les méthodes keySet() et values() renvoient chacune un Set. Puisque nous savons comment utiliser forEach() avec un Set, c'est facile.  
### Real World Scenari: (Scénario du monde réel)    
Vous n'avez pas besoin de le savoir pour l'examen, mais Java a une interface fonctionnelle appelée **BiConsumer**. La signature de la méthode forEach pour une Map est:   

		default void forEach(BiConsumer<? super K, ? super V> action)
Cela fonctionne comme Consumer sauf qu'il peut prendre deux paramètres. Cette interface fonctionnelle vous permet d'utiliser forEach() avec des paires clé/valeur de la forme Map.    

		Map<String, Integer> bun = new HashMap<>();
		bun.put("long ear", 3);		
		bun.put("floppy", 8);		
		bun.put("hoppy", 1);
		bun.forEach((k, v) -> System.out.println(k + " " + v));
cela afficher:

	[long ear ,3][floppy ,8][hoppy ,1]
	
