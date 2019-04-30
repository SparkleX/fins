insert into OJDT("Id", "RefDate", "Memo", "LocTotal") values(1,NULL,'M1',0);
insert into OJDT("Id", "RefDate", "Memo", "LocTotal") values(2,NULL,'M1',0);
insert into JDT1("Id", "ParentId", "AccountId") values(1,1,1);
insert into JDT1("Id", "ParentId", "AccountId") values(2,1,1);
insert into JDT1("Id", "ParentId", "AccountId") values(3,2,1);
insert into JDT1("Id", "ParentId", "AccountId") values(4,2,1);

insert into OACT("Id", "AcctCode") values(1,'A0001');
insert into OACT("Id", "AcctCode") values(2,'A0002');