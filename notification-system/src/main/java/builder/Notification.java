package builder;

import java.util.UUID;

import enums.*;

public class Notification{
    private final String id;
    private final String userId;
    private final String subject;
    private final String body;

    private final Channel channel;
    private final Type type;
    private Status status;
    private final Priority priority;

    private int retryCnt;

    private Notification(Builder b){
        this.id = UUID.randomUUID().toString();
        this.userId= b.userId;
        this.subject = b.subject;
        this.body = b.body;

        this.channel = b.channel;
        this.type = b.type;
        this.status = b.status;
        this.priority = b.priority;

        this.retryCnt = 0;
    }

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public Channel getChannel() { return channel; }
    public Type getType() { return type; }
    public Status getStatus() { return status; }
    public Priority getPriority() { return priority; }
    public int getRetryCnt() { return retryCnt; }

    public void setStatus(Status status){
        this.status = status;
    }

    public void incRetryCnt(){
        retryCnt++;
    }

    public static class Builder{
        private final String userId;
        private String subject;
        private final String body;

        private final Channel channel;
        private final Type type;
        private Status status = Status.PENDING;
        private Priority priority = Priority.MEDIUM;

        public Builder(String userId, String body, Channel channel, Type type){
            this.userId = userId;
            this.body = body;
            this.channel = channel;
            this.type = type;
        }

        public Builder subject(String subject){
            this.subject = subject;
            return this;
        }

        public Builder priority(Priority priority){
            this.priority = priority;
            return this;
        }

        public Notification build(){
            if (userId == null || body == null || channel == null || type == null)
                throw new IllegalStateException("mandatory fields missing");
            return new Notification(this);
        }
    }
}
