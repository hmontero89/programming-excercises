public class Path{

	public static int maxValue(int[] pathArray, int k) {
		int lengthArray = pathArray.length;
		int maxValue = 0;
		int visitedIndex = 0;

		if (lengthArray > 0) {
			maxValue = pathArray[visitedIndex];
		}
		if(lengthArray > 1){
			int pathToVisit = 1;
			int bestPath = pathArray[pathToVisit];

			while (visitedIndex < lengthArray - 1) {

				for(int pathIndex = 1; (pathIndex <= k) && (visitedIndex + pathIndex < lengthArray); pathIndex++) {
					if(pathIndex == 1){
						pathToVisit = visitedIndex + pathIndex;
						bestPath = pathArray[pathToVisit];
					}else{
						if(pathArray[visitedIndex + pathIndex] > bestPath){
							pathToVisit = visitedIndex + pathIndex;
							bestPath = pathArray[pathToVisit];
						}
					}
				}
				System.out.println("bestPath = " + bestPath);
				visitedIndex = pathToVisit;
				maxValue += bestPath;
			}
		}
		return maxValue;
	}

	public static void main(String[] args){
		//int[] arrayToCheck = {10,-20,-5};
		//int[] arrayToCheck = {-43,-38,-24,27,-67,77,2,-94,-28,-33}; Result= -22
		int[] arrayToCheck = {70,-88,17,-20,-72,21,88,-37,72,-52};
		
		int k = 3;
		int result = maxValue(arrayToCheck, k);

		System.out.println("Max Value = "+result);
	}
}