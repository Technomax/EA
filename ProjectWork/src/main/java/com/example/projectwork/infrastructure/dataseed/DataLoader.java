package com.example.projectwork.infrastructure.dataseed;

import com.example.projectwork.domain.*;
import com.example.projectwork.domain.common.*;
import com.example.projectwork.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    PlanRepository planRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BadgeRepository badgeRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    TimeslotRepository timeslotRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MembershipRepository membershipRepository;
    @Override
    public void run(String... args) throws Exception {
        loalData();
    }

    public Auditable buildAuditable(){
        return new Auditable("Admin", "Admin", LocalDate.of(2022, 5, 5), LocalDate.of(2022, 5, 5));
    }

    public AuditableWithActive buildAuditableWithActive(){
        return new AuditableWithActive(true,"Admin", "Admin", LocalDate.of(2022, 5, 5), LocalDate.of(2022, 5, 5));
    }
    public LocalDate buildLocalDate(){
        return LocalDate.of(2022,1,1);
    }
    public LocalTime buildLocalTime(){
        return LocalTime.of(8,0,0);
    }

    public LocalDateTime buildLocalDateTime(){
        return LocalDateTime.of(2022, 12, 4, 12, 0);
    }

    public Transaction buildTransaction(long id, TransactionType tranType){
        return new Transaction(id,buildLocalDate(),tranType,buildAuditable());
    }

    public Membership buildMembership(long id,int maxAllowedUsages, RecurringType recurringType, int remainingUsages){
        return new Membership(id,buildLocalDateTime(),buildLocalDateTime(),maxAllowedUsages,recurringType,buildLocalDate(),
                remainingUsages,buildAuditableWithActive());
    }
    public Badge buildBadge(long id,String txtCode, HashSet transactionSet){
        return new Badge(id,txtCode,null,transactionSet,buildAuditableWithActive());
    }

    public Role buildRole(long id,String name){
        return new Role(id,name,name+" Description",buildAuditableWithActive());
    }

    public Member buildMember(long id,String firstName, String lastName,String email, String phoneNo, HashSet roleSet, HashSet membership){
        return new Member(id, firstName, lastName,email,phoneNo, new Address("1000 N 4th Street", "Fairfield", "IOWA", "52667"),
                roleSet, membership, buildAuditableWithActive());
    }

    public Timeslot buildTimeslot(long id){
        return new Timeslot(id, buildLocalTime().plusHours(id*2),buildLocalTime().plusHours(id*2+2), buildAuditableWithActive());
    }

    public Plan buildPlan(long id, String planName, HashSet role, HashSet timeslot, HashSet membership, HashSet event){
        return new Plan(id,planName,planName+" Description", role,timeslot,membership,event,  buildAuditableWithActive());
    }

    public Location buildLocation(long id,String name, int capacity,LocationType locationType,HashSet event,HashSet timeslot){
        return new Location(id,name, name + " description",new Address("1000 N 4th Street", "Fairfield", "IOWA", "52667"),
                     capacity,locationType,event,timeslot, buildAuditableWithActive());
    }

    public Event buildEvent(int id, HashSet transaction) {
        Event event3 = new Event(id, transaction, buildAuditableWithActive());
        return event3;
    }

    private void loalData() {
        ///////////////////////////////////TRANSACTION DATA//////////////////////////////////////////////
        List<Transaction> transactions=Arrays.asList(buildTransaction(1,TransactionType.IN), buildTransaction(2,TransactionType.IN),
                buildTransaction(3,TransactionType.IN),
                buildTransaction(4,TransactionType.IN), buildTransaction(5,TransactionType.IN),
                buildTransaction(6,TransactionType.IN), buildTransaction(7,TransactionType.IN),
                buildTransaction(8,TransactionType.IN),
                buildTransaction(9,TransactionType.IN), buildTransaction(10,TransactionType.IN));
        HashSet transactionSet1= new HashSet(Arrays.asList(transactions.get(0),transactions.get(1),transactions.get(2)));
        HashSet transactionSet2= new HashSet(Arrays.asList(transactions.get(3),transactions.get(4)));
        HashSet transactionSet3= new HashSet(Arrays.asList(transactions.get(5),transactions.get(6)));
        HashSet transactionSet4= new HashSet(Arrays.asList(transactions.get(7),transactions.get(8)));
        HashSet transactionSet5= new HashSet(Arrays.asList(transactions.get(9)));
        transactions.forEach(transactionRepository::save);
        //////////////////////////////////////MEMBERSHIP DATA///////////////////////////////////////////////////
        List<Membership> memberships=Arrays.asList(buildMembership(1,60,RecurringType.MONTHLY,40),
                buildMembership(2,60,RecurringType.MONTHLY,40),
                buildMembership(3, 60,RecurringType.MONTHLY,40));
        HashSet membershipset1 = new HashSet(Arrays.asList(memberships.get(0)));
        HashSet membershipset2 = new HashSet(Arrays.asList(memberships.get(1)));
        HashSet membershipset3 = new HashSet(Arrays.asList(memberships.get(2)));
        memberships.forEach(membershipRepository::save);
        /////////////////////////////////////////BADGE DATA////////////////////////////////////////////////
        Arrays.asList(buildBadge(1,"A001",transactionSet1),buildBadge(2,"A002",transactionSet2)
                ,buildBadge(3,"A003",transactionSet3)
                ,buildBadge(4,"A004",transactionSet4)
                ,buildBadge(5,"A005",transactionSet5)).forEach(badgeRepository::save);
        ///////////////////////ROLE DATA//////////////////////////////////////////////////////////////////
        List<Role> roles= Arrays.asList(buildRole(1,"Student"),buildRole(2,"Faculty"),buildRole(3,"Staff"),
                buildRole(3,"Internal Visitor Faculty"),buildRole(3,"Student Exchange"));
        HashSet roleset1 = new HashSet(Arrays.asList(roles.get(0),roles.get(1)));
        HashSet roleset2 = new HashSet(Arrays.asList(roles.get(1),roles.get(2)));
        HashSet roleset3 = new HashSet(Arrays.asList(roles.get(2),roles.get(0)));
        roles.forEach(roleRepository::save);
        ////////////////////MEMBER DATA/////////////////////////////////////////////////////////////////////
        Arrays.asList(buildMember(1,"Anil","Maharjan","abc@gmail.com","xxx",roleset1,membershipset1),
                buildMember(2,"Priya","Giri","abc@gmail.com","xxx",roleset2,membershipset2),
                buildMember(3,"Ahmed","Fayaz","abc@gmail.com","xxx",roleset3,membershipset3),
                buildMember(4,"Mahmoud","Anwar","abc@gmail.com","xxx",roleset1,membershipset2),
                buildMember(5,"Biniam","Grebrealak","abc@gmail.com","xxx",roleset2,membershipset3)).forEach(memberRepository::save);
        /////////////////////////////////////////////TIMESLOT DATA////////////////////////////////////////////
        List<Timeslot> timeslots=Arrays.asList(buildTimeslot(1),buildTimeslot(2),buildTimeslot(3));
        HashSet timeslotset1 = new HashSet(Arrays.asList(timeslots.get(0),timeslots.get(1)));
        HashSet timeslotset2 = new HashSet(Arrays.asList(timeslots.get(1),timeslots.get(2)));
        HashSet timeslotset3 = new HashSet(Arrays.asList(timeslots.get(2),timeslots.get(1)));
        timeslots.forEach(timeslotRepository::save);
        ///////////////////////////////////EVENT DATA//////////////////////////////////////////////
        List<Event> events= Arrays.asList(buildEvent(1,transactionSet1), buildEvent(2,transactionSet2), buildEvent(3,transactionSet3)
                , buildEvent(4,transactionSet2), buildEvent(5,transactionSet4), buildEvent(6,transactionSet2), buildEvent(7,transactionSet5));
        HashSet eventset1= new HashSet(Arrays.asList(events.get(0),events.get(1)));
        HashSet eventset2= new HashSet(Arrays.asList(events.get(2)));
        HashSet eventset3= new HashSet(Arrays.asList(events.get(3)));
        HashSet eventset4= new HashSet(Arrays.asList(events.get(4),events.get(5),events.get(6)));
        events.forEach(eventRepository::save);
        ////////////////////////////////PLAN DATA/////////////////////////////////////////////////////////
        List<Plan> plans=Arrays.asList(buildPlan(1,"Bronze",roleset1,timeslotset1,membershipset1,eventset1),
                buildPlan(2,"Silver",roleset1,timeslotset2,membershipset2,eventset2),
                buildPlan(3,"Gold",roleset1,timeslotset3,membershipset3,eventset3),
                buildPlan(4,"Platinum",roleset1,timeslotset1,membershipset3,eventset4));
        plans.forEach(planRepository::save);
        /////////////////////////////////////LOCATION DATA////////////////////////////////////////////////////
        List<Location> locations=Arrays.asList(buildLocation(1,"xyz",500,LocationType.DINNING_HALL,eventset1,timeslotset1),
                buildLocation(2,"xyz",500,LocationType.CLASSROOM,eventset2,timeslotset2),
                buildLocation(3,"xyz",500,LocationType.DORMITORY,eventset3,timeslotset3),
                buildLocation(4,"xyz",500,LocationType.FLYING_HALL,eventset4,timeslotset1),
                buildLocation(5,"xyz",500,LocationType.GYMNASIUM,eventset1,timeslotset2),
                buildLocation(6,"xyz",500,LocationType.MEDITATION_HALL,eventset2,timeslotset3));
        locations.forEach(locationRepository::save);

    }
}