package com.oreooo.library;


public class MessageEvent {

    public static class ProduceTaskScanEvent {
        int Id;

        public ProduceTaskScanEvent(int TaskId) {
            this.Id = TaskId;
        }

        public int getId(){
            return Id;
        }
    }
}
