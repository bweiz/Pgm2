
public class RedBlackTree<Key extends Comparable<Key>, Value> {
	
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	public class Node{
		Key key;
		Value val;
		Node left, right;
		int n;
		boolean color;
		
		Node(Key key, Value val, int n, boolean color) {
			this.key = key;
			this.val = val;
			this.n = n;
			this.color = color;
		}
		
	}
	
	
	private int size(Node h) {
		return h == null ? 0 : h.n;
	}
	
	private boolean isRed(Node x) {
		if (x == null) return false;
		return x.color == RED;
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
		root.color = BLACK;
	}
	
	private Node put(Node h, Key key, Value val) {
		if (h == null) {
			return new Node(key, val, 1, RED);
		}
		
		int cmp = key.compareTo(h.key);
		if		(cmp < 0) h.left = put(h.left, key, val);
		else if (cmp > 0) h.right = put(h.right, key, val);
		else h.val = val;
		
		if (isRed(h.right) && !isRed(h.left))		h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))	h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))		flipColors(h);
		
		h.n = size(h.left)+ size(h.right) + 1;  
		return h;
	}
	
    public Node find(Key key) {
        Node temp = root;
        while (temp != null) {
        	int cmp = key.compareTo(temp.key);
            if (cmp == 0) {
                return temp; // Key found
            } else if (cmp < 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }
	
	public Node findMin() {
		Node n = root;
		while(n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	public Node findMax() {
		Node n = root;
		while(n.right != null) {
			n = n.right;
		}
		return n;
	}
	
	public Key getKey(Node n) {
		return n.key;
	}
	
	public Value getValue(Node n) {
		return n.val;
	}
}












