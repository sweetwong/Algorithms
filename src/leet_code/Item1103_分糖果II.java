package leet_code;

class Item1103_分糖果II {

  public int[] distributeCandies(int candies, int num_people) {
    int[] people = new int[num_people];
    int count = 1;
    while (candies > 0) {
      for (int i = 0; i < num_people; i++) {
        if (count >= candies) {
          people[i] += candies;
          candies = 0;
          break;
        }
        people[i] += count;
        candies -= count;
        count++;
      }
    }
    return people;
  }

}
