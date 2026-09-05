class TimeMap {
    private HashMap<String, List<Pair<Integer, String>>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(timeMap.get(key) == null)
            return "";
        int l = 0, r = timeMap.get(key).size() - 1;
        String prev = "";
        while(l <= r) {
            int m = l + (r - l) / 2;
            List<Pair<Integer, String>> list = timeMap.get(key);
            if(list.get(m).getTime() <= timestamp) {
                prev = list.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return prev;
    }

    private static class Pair<T, V> {
        private final T timestamp;
        private final V value;

        public Pair(T timestamp, V value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        public T getTime() {
            return timestamp;
        }

        public V getValue() {
            return value;
        }
    }
}
