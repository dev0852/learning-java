import java.util.Random;

public class Skiplist {
    private Node head;
    private int size;
    private int maxLevel;
    private Random random;

    public Skiplist() {
        this.head = new Node(Integer.MIN_VALUE);
        this.size = 0;
        this.maxLevel = 0;
        this.random = new Random();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(int target) {
        return this.search(target) != null;
    }

    public void add(int num) {
        Node node = new Node(num);
        Node[] update = new Node[this.maxLevel + 1];
        Node cur = this.head;
        for (int i = this.maxLevel; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }
        int level = 0;
        while (level < this.maxLevel && this.random.nextInt(2) == 1) {
            level++;
        }
        if (level > this.maxLevel) {
            this.maxLevel = level;
        }
        node.next[level] = update[level].next[level];
        for (int i = 0; i <= level; i++) {
            update[i].next[i] = node;
        }
        this.size++;
    }

    public boolean remove(int num) {
        Node[] update = new Node[this.maxLevel + 1];
        Node cur = this.head;
        for (int i = this.maxLevel; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }
        Node node = update[0].next[0];
        if (node != null && node.val == num) {
            for (int i = 0; i <= this.maxLevel; i++) {
                if (update[i].next[i] != node) {
                    break;
                }
            }
            for (int i = 0; i <= this.maxLevel; i++) {
                update[i].next[i] = node.next[i];
            }
            this.size--;
            return true;
        }
        return false;
    }

    public Node search(int target) {
        Node cur = this.head;
        for (int i = this.maxLevel; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < target) {
                cur = cur.next[i];
            }
        }
        return cur.next[0];
    }

    public int maxLevel() {
        return this.maxLevel;
    }

    public int[] getLevels() {
        int[] levels = new int[this.maxLevel + 1];
        Node cur = this.head;
        for (int i = this.maxLevel; i >= 0; i--) {
            while (cur.next[i] != null) {
                cur = cur.next[i];
                levels[i]++;
            }
        }
        return levels;
    }

    public int getLevel(int num) {
        Node cur = this.head;
        for (int i = this.maxLevel; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
        }
        return cur.next[0] != null && cur.next[0].val == num ? this.maxLevel : -1;
    }


    public static void main(String[] args) {
        Skiplist sl = new Skiplist();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        sl.add(9);
        sl.add(10);
        sl.add(11);
        sl.add(12);
        sl.add(13);
        sl.add(14);
        sl.add(15);
        sl.add(16);
        sl.add(17);
        sl.add(18);
        sl.add(19);
        //print(sl);
        System.out.println(sl.getLevel(1));
        System.out.println(sl.getLevel(2));
        System.out.println(sl.getLevel(3));
        System.out.println(sl.getLevel(4));
        System.out.println(sl.getLevel(5));
        System.out.println(sl.getLevel(6));
        System.out.println(sl.getLevel(7));
        System.out.println(sl.getLevel(8));
    }
};
