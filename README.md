# OSRS Quant
_OSRS Quant_ is a bot for automatically trading items on the Old School RuneScape 
Grand Exchange for profit.

## Flow

The logic of the bot is split into atomic operations, or 
_commands_. The following flow is used to find items worth 
investing in:

 - Open Grand Exchange
 - For every potential item
   - Open buy slot
   - Select item to buy
   - Set price high (to determine margin)
   - Finalize buy offer
   - Wait for item to finish buying
   - Collect item
   - Open sell slot
   - Select item to sell
   - Set price low (to determine margin)
   - Finalize sell offer
   - Wait for item to finish selling
   - Collect coins from sale
   - Decide whether to invest in item based on margin
   
  
Once an item has been selected to invest in, the following 
flow is used:

 - Open buy slot
 - Select item to buy
 - Set price as determined earlier
 - Set quantity to buy in bulk
 - Finalize buy offer
 - Wait for item to finish buying
 - Collect item
 - Open sell slot
 - Select item to sell
 - Set price as determined earlier
 - Set offer to sell all bought items
 - Finalize sell offer
 - Wait for item to finish selling
 
 ## Error cases
 
 The bot must be able to recover from the following:
 
 - Item does not buy or sell within a time limit
 - Bulk buy or sell only partially completes
 - Bot reaches trade limit for item on G.E.
 
## Optimizations

 - Using all G.E. boxes to invest in multiple items at once
 - Begin selling item before all buys have completed
 
 
  
 
 
   