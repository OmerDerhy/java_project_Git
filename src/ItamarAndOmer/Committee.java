package ItamarAndOmer;

public class Committee {
    private String name;
    private Lecturer chairperson;
    private Lecturer[] members;
    private int memberCount;

    public Committee(String name, Lecturer chairperson) {
        this.name = name;
        this.chairperson = chairperson;
        this.members = new Lecturer[2];
        this.memberCount = 0;
    }

    public String getName() {
        return name;
    }

    public Lecturer getChairperson() {
        return chairperson;
    }

    public void setChairperson(Lecturer chairperson) {
        this.chairperson = chairperson;
    }

    public void addMember(Lecturer lecturer) {
        if (memberCount == members.length) {
            Lecturer[] newMembers = new Lecturer[members.length * 2];

            for (int i = 0; i < memberCount; i++) {
                newMembers[i] = members[i];
            }

            members = newMembers;
        }

        members[memberCount++] = lecturer;
    }

    public void removeMember(Lecturer lecturer) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i] == lecturer) {
                for (int j = i; j < memberCount - 1; j++) {
                    members[j] = members[j + 1];
                }

                members[--memberCount] = null;

                return;
            }
        }
    }

    public boolean isMember(Lecturer lecturer) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i] == lecturer) {
                return true;
            }
        }

        return false;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public Lecturer[] getMembers() {
        Lecturer[] result = new Lecturer[memberCount];

        for (int i = 0; i < memberCount; i++) {
            result[i] = members[i];
        }

        return result;
    }

    @Override
    public String toString() {
        String string =
                "Committee:" + name + "\nChairperson:" + chairperson.getName() + "\nMembers (" + memberCount + "):";

        if (memberCount == 0) {
            string += " None";
        } else {
            String memberList = "\n";

            for (int i = 0; i < memberCount; i++) {
                memberList += (i + ". " + members[i].getName() + "\n");
            }

            string += memberList;
        }

        return string;
    }
}