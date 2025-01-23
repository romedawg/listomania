Use AWS SDLS(codedeploy, build, etc.)

Terraform to create these resources
 - ECS 
   - cluster
   - service
   - task definition
     - Create task role
     - Create execution role
 - EC2
   - Load Balancer
   - Target Group
   - postgres server
     - ec2
       - docker container via shell scrip
 - Route53
   - DNS
 - VPC items assume(likely created separately)
