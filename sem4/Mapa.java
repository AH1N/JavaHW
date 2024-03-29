package sem4;

public class Mapa<K, V> {
    Node<K, V>[] nodes = new Node[16];


    public V put(K key, V value) {
        V result = null;
        Node<K, V> inputNode = new Node<>(key, value);
        Integer hash16 = inputNode.key.hashCode() % 16;
        if (nodes[hash16] != null) {
            Node<K, V> currentNode = nodes[hash16];
            while (currentNode != null) {
                if (currentNode.key == key) {
                    result = currentNode.value;
                    currentNode.value = value;
                    return result;
                }
                currentNode = currentNode.nextnode;
            }
            inputNode.nextnode = nodes[hash16];
        }
        nodes[hash16] = inputNode;
        return result;
    }

    public V get(K key) {
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                return currentNode.value;
            }
            currentNode = currentNode.nextnode;
        }
        return null;
    }



    public V remove(K key) {
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        if (currentNode != null) {
            while (currentNode.nextnode != null) {
                if (currentNode.nextnode.key == key) {
                    V result = currentNode.nextnode.value;
                    currentNode.nextnode = currentNode.nextnode.nextnode;
                    return result;
                }
                currentNode = currentNode.nextnode;
            }
        }
        return null;
    }

    public void replace(K key, V value) {
        V result = null;
        Node<K, V> inputNode = new Node<>(key, value);
        Integer hash16 = inputNode.key.hashCode() % 16;
        if (nodes[hash16] != null) {
            Node<K, V> currentNode = nodes[hash16];
            while (currentNode != null) {
                if (currentNode.key == key) {
                    result = currentNode.value;
                    currentNode.value = value;
                }
                currentNode = currentNode.nextnode;
            }
            inputNode.nextnode = nodes[hash16];
        }
        nodes[hash16] = inputNode;

    }

    public Integer size() {
        int count = 0;
        for (Node<K, V> node : nodes) {
            Node<K, V> currentNode = node;
            while (currentNode != null) {
                count++;
                currentNode = currentNode.nextnode;
            }
        }
        return count;
    }

    public boolean contains(K key,V value) {
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key && currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.nextnode;
        }
        return false;
    }

    public boolean contValue(V value) {
        for (Node<K, V> node : nodes) {
            Node<K, V> currentNode = node;
            while (currentNode != null && currentNode.value !=value) {

                currentNode = currentNode.nextnode;
            }
        }
        return true;
    }

}


