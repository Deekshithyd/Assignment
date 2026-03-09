import java.util.*;

class Candidate {
    int id;
    String name, email, password;

    Candidate(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

class Job {
    int jobId;
    String title, company;
    boolean isOpen = true;

    Job(int jobId, String title, String company) {
        this.jobId = jobId;
        this.title = title;
        this.company = company;
    }
}

class Application {
    int candidateId, jobId;
    String status;

    Application(int cId, int jId, String status) {
        this.candidateId = cId;
        this.jobId = jId;
        this.status = status;
    }
}

public class JobPortalConsole {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Candidate> candidates = new ArrayList<>();
    static ArrayList<Job> jobs = new ArrayList<>();
    static ArrayList<Application> applications = new ArrayList<>();

    static int candidateIdCounter = 1;
    static int jobIdCounter = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== JOB PORTAL =====");
            System.out.println("1. Candidate");
            System.out.println("2. Company");
            System.out.println("3. Admin");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> candidateSection();
                case 2 -> companySection();
                case 3 -> adminSection();
                case 4 -> System.exit(0);
            }
        }
    }

    static void candidateSection() {
        System.out.println("\n1. Register\n2. Login");
        int choice = sc.nextInt();

        if (choice == 1) registerCandidate();
        else if (choice == 2) loginCandidate();
    }

    static void registerCandidate() {
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        candidates.add(new Candidate(candidateIdCounter++, name, email, pass));
        System.out.println("✅ Registered!");
    }

    static void loginCandidate() {
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        for (Candidate c : candidates) {
            if (c.email.equals(email) && c.password.equals(pass)) {
                candidateMenu(c.id);
                return;
            }
        }
        System.out.println(" Invalid login!");
    }

    static void candidateMenu(int id) {
        while (true) {
            System.out.println("\n--- Candidate Menu ---");
            System.out.println("1. View Jobs");
            System.out.println("2. Apply Job");
            System.out.println("3. View Applications");
            System.out.println("4. Withdraw Application");
            System.out.println("5. Logout");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> viewJobs();
                case 2 -> applyJob(id);
                case 3 -> viewApplications(id);
                case 4 -> withdrawApplication(id);
                case 5 -> { return; }
            }
        }
    }


    static void companySection() {
        while (true) {
            System.out.println("\n--- Company Menu ---");
            System.out.println("1. Post Job");
            System.out.println("2. Update Job");
            System.out.println("3. Delete Job");
            System.out.println("4. View Applicants");
            System.out.println("5. Back");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> postJob();
                case 2 -> updateJob();
                case 3 -> deleteJob();
                case 4 -> viewApplicants();
                case 5 -> { return; }
            }
        }
    }

    static void postJob() {
        sc.nextLine();
        System.out.print("Company: ");
        String comp = sc.nextLine();

        System.out.print("Job Title: ");
        String title = sc.nextLine();

        jobs.add(new Job(jobIdCounter++, title, comp));
        System.out.println(" Job Posted!");
    }

    static void updateJob() {
        viewJobs();
        System.out.print("Enter Job ID: ");
        int id = sc.nextInt();

        sc.nextLine();
        for (Job j : jobs) {
            if (j.jobId == id) {
                System.out.print("New Title: ");
                j.title = sc.nextLine();
                System.out.println(" Updated!");
            }
        }
    }

    static void deleteJob() {
        viewJobs();
        System.out.print("Enter Job ID: ");
        int id = sc.nextInt();

        jobs.removeIf(j -> j.jobId == id);
        System.out.println(" Deleted!");
    }

    static void viewApplicants() {
        for (Application a : applications) {
            System.out.println("Candidate ID: " + a.candidateId +
                    " applied for Job ID: " + a.jobId +
                    " Status: " + a.status);
        }
    }

    // 🔷 Admin Section
    static void adminSection() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View Candidates");
            System.out.println("2. Remove Candidate");
            System.out.println("3. View Stats");
            System.out.println("4. Back");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> candidates.forEach(c -> System.out.println(c.id + " " + c.name));
                case 2 -> removeCandidate();
                case 3 -> showStats();
                case 4 -> { return; }
            }
        }
    }

    static void removeCandidate() {
        System.out.print("Enter Candidate ID: ");
        int id = sc.nextInt();

        candidates.removeIf(c -> c.id == id);
        System.out.println(" Removed!");
    }

    static void showStats() {
        System.out.println("Total Candidates: " + candidates.size());
        System.out.println("Total Jobs: " + jobs.size());
        System.out.println("Total Applications: " + applications.size());
    }

    // 🔷 Common Functions
    static void viewJobs() {
        for (Job j : jobs) {
            if (j.isOpen)
                System.out.println(j.jobId + ". " + j.title + " (" + j.company + ")");
        }
    }

    static void applyJob(int cid) {
        viewJobs();
        System.out.print("Enter Job ID: ");
        int jid = sc.nextInt();

        applications.add(new Application(cid, jid, "Applied"));
        System.out.println(" Applied!");
    }

    static void viewApplications(int cid) {
        for (Application a : applications) {
            if (a.candidateId == cid)
                System.out.println("Job ID: " + a.jobId + " Status: " + a.status);
        }
    }

    static void withdrawApplication(int cid) {
        System.out.print("Enter Job ID: ");
        int jid = sc.nextInt();

        for (Application a : applications) {
            if (a.candidateId == cid && a.jobId == jid) {
                a.status = "Withdrawn";
                System.out.println(" Withdrawn!");
            }
        }
    }
}