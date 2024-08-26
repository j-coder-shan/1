class list {
    int[] list;
    int size, count;
    list(int maxSize){
        size = maxSize;
        list = new int[size];
        count = 0;
    }
    public boolean isListEmpty(){
        return count == 0;
    }
    public boolean isListFull(){
        return count == size;
    }
    public int listSize(){
        return count;
    }
    public void insertLast(int value){
        if(isListFull()){
            System.out.println("List is full!");
        }
        else {
            list[count++] = value;
        }
    }
    public void insertList(int position, int value){
        if(isListFull()){
            System.out.println("List is full!");
        } else if (0 > position || position >= size) {
            System.out.println("Entered position is out of bound!");
        }else {
            for (int i = count - 1; i >= position ; i--) {
                list[i + 1] = list[i];
            }
            list[position] = value;
            count++;
        }
    }
    public void deleteList(int position){
        if(isListEmpty()){
            System.out.println("List is empty!");
        } else if (0 > position || position >= size) {
            System.out.println("Entered position is out of bound!");
        } else {
            for (int i = position; i < count - 1 ; i++) {
                list[i] = list[i +1];
            }
            count--;
        }
    }
    public int retrieveList(int position){
        if(isListEmpty()){
            System.out.println("List is empty!");
            return 0;
        } else if (0 > position || position >= size) {
            System.out.println("Entered position is out of bound!");
            return 0;
        } else {
            return list[position];
        }
    }
    public void replaceList(int position, int value){
        if(isListEmpty()){
            System.out.println("List is empty!");
        } else if (0 > position || position >= size) {
            System.out.println("Entered position is out of bound!");
        } else {
            list[position] = value;
        }
    }
    public void traverseList(){
        if(isListEmpty()){
            System.out.println("List is empty!");
        }else {
            for (int i = 0; i < count; i++) {
                System.out.println(list[i]);
            }
        }
    }
}

class selectionSort {
    static int[] list;
    private void sort(){
        for (int i = list.length - 1; i >= 0 ; i--) {
            int maxIndex = getMaxIndex(i);
            int temp = list[maxIndex];
            list[maxIndex] = list[i];
            list[i] = temp;
        }
    }
    private int getMaxIndex(int maxIndex) {
        int index = maxIndex;
        for (int i = index; i >= 0 ; i--) {
            if (list[index] < list[i]){
                index = i;
            }
        }
        return index;
    }

    //insertion
    private static void sortedList() {
        for (int i = 0; i < list.length; i++) {
            int j = i;
            while (j > 0){
                if (list[j] < list[j-1]){
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
                j--;
            }
        }
    }

    //quick
    public void sort_quick(int start, int end, int[] list) {
        if (start < end) {
            int partitionIndex = partition(start, end, list);
            sort_quick(start, partitionIndex - 1, list);
            sort_quick(partitionIndex + 1, end, list);
        }
    }
    private int partition(int start, int end, int[] list) {
        int pivot = list[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (list[j] < pivot) {
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        int temp = list[i + 1];
        list[i + 1] = list[end];
        list[end] = temp;
        return i + 1;
    }

    //bubble
    public void sort_bubble(){
        int l = list.length;
        for (int i = 0; i < l; i++) {
            for (int j = 1; j < (l - i); j++) {
                if (list[j] < list[j-1]){
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
            }
        }
    }
}

