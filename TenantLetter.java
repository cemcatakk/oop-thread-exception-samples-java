public class TenantLetter {
    private Person tenant;
    private String content;

    public TenantLetter(Person tenant, String content) {
        this.tenant = tenant;
        this.content = content;
    }

    public Person getTenant() {
        return tenant;
    }

    public void setTenant(Person tenant) {
        this.tenant = tenant;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString(){
        return "Letter to person: "+ getTenant().getName() +". Content:"+getContent();
    }
}
