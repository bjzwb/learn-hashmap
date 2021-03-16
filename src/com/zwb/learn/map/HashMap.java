package com.zwb.learn.map;

public class HashMap<K, V> implements Map<K, V> {

    Entry<K, V> table[] = null;

    public HashMap() {
        table = new Entry[16];
    }

    private int size = 0;

    /**
     * 通过key进行hashcode取模
     * 下标去数组下标对应的Entry对象
     * 对象是否为空 如果为空则直接存储
     * 不为空 则用链表存储
     * 赋值返回
     *
     * @param k
     * @param v
     * @return
     */
    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            //没有冲突
            table[index] = new Entry<>(k, v, index, entry);
            size++;
        } else {
            //已经有了
            table[index] = new Entry<>(k, v, index, entry);
        }
        return table[index].getValue();
    }

    private int hash(K k) {
        int i = k.hashCode() % 10;
        return i >= 0 ? i : -i;
    }

    /**
     * 下标去数组下标对应的Entry对象
     * 查询的key和当前对象的key是否相同
     * 相同 直接返回
     * 不相同 next是否相同 如果为空 返回
     * 不为空 查询的key和当前对象的key是否相同
     * 直到相同或者next为空为止 返回
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        if (size == 0) {
            return null;
        }
        int index = hash(k);
        Entry<K, V> entry = findValue(k, table[index]);
        return entry == null ? null : entry.getValue();
    }

    private Entry<K, V> findValue(K k, Entry<K, V> kvEntry) {
        if (k.equals(kvEntry.getKey()) || k == kvEntry.getKey()) {
            return kvEntry;
        } else {
            if (kvEntry.next != null) {
                return findValue(k, kvEntry.next);
            }
        }
        return null;

    }

    @Override
    public int size() {
        return size;
    }


    class Entry<K, V> implements Map.Entry<K, V> {
        K k;
        V v;
        int hash;
        Entry<K, V> next;

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

}
